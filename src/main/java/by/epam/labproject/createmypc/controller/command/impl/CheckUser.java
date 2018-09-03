package by.epam.labproject.createmypc.controller.command.impl;

import by.epam.labproject.createmypc.controller.command.Command;
import by.epam.labproject.createmypc.controller.security.AesCipher;
import by.epam.labproject.createmypc.controller.validation.CompositeValidator;
import by.epam.labproject.createmypc.controller.validation.ValidationResult;
import by.epam.labproject.createmypc.controller.validation.impl.UserLoginValidator;
import by.epam.labproject.createmypc.controller.validation.impl.UserPasswordValidator;
import by.epam.labproject.createmypc.controller.validation.messages.Message;
import by.epam.labproject.createmypc.domain.User;
import by.epam.labproject.createmypc.service.ServiceFactory;
import by.epam.labproject.createmypc.service.UserService;
import by.epam.labproject.createmypc.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CheckUser implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.MAIN_PAGE);
        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();
        User checkedUser = null;
        ValidationResult result = validateCheckForm( request.getParameter("login"), request.getParameter("password"));
        if (result.isSucceed()) {
            String login = request.getParameter("login");
            byte[] plainPassword = request.getParameter("password").getBytes(StandardCharsets.UTF_8);
            String key = "notatopsecretkey";
            String hashPassword = AesCipher.encrypt(key, plainPassword);
            try {checkedUser = userService.checkUser(login, hashPassword);
                  if (checkedUser != null) {
                        request.getSession(true).setAttribute("user", checkedUser);
                    }else {
                     List<Message> messages =  new ArrayList<Message>();
                      messages.add(new Message("Can't find user with a login or password"));
                      request.setAttribute("errorMessages", messages);
                  }
            } catch (ServiceException e) {
                //todo
                //goToPage = JSPPagePath.ERROR_PAGE;
                // log
                e.printStackTrace();
            }
        } else {
            List<Message> messages= result.getResultMessages();
            request.setAttribute("errorMessages", messages);
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException  e) {
            //log ?????????????
        }
    }

        private ValidationResult validateCheckForm(String userLogin,String userPassword){
            CompositeValidator validator = new CompositeValidator();
            validator.add(new UserLoginValidator(userLogin));
            validator.add(new UserPasswordValidator(userPassword));
            return validator.validate();
        }

}

package by.epam.labproject.createmypc.controller.command.impl;

import by.epam.labproject.createmypc.controller.command.Command;
import by.epam.labproject.createmypc.controller.security.AesCipher;
import by.epam.labproject.createmypc.controller.validation.CompositeValidator;
import by.epam.labproject.createmypc.controller.validation.ValidationResult;
import by.epam.labproject.createmypc.controller.validation.impl.UserEmailValidator;
import by.epam.labproject.createmypc.controller.validation.impl.UserLoginValidator;
import by.epam.labproject.createmypc.controller.validation.impl.UserPasswordValidator;
import by.epam.labproject.createmypc.controller.validation.messages.Message;
import by.epam.labproject.createmypc.domain.User;
import by.epam.labproject.createmypc.service.ServiceFactory;
import by.epam.labproject.createmypc.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class RegUser implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();

        ValidationResult result =validateRegForm(request.getParameter("username"),request.getParameter("password"),request.getParameter("email"));
        if (result.isSucceed()){
            Map<String,String> userParams = new HashMap<String,String>();
            Enumeration enumeration = request.getParameterNames();
            while (enumeration.hasMoreElements()) {
                String paramName = (String)enumeration.nextElement();
                if(paramName.equalsIgnoreCase("password")){
                    String key = "notatopsecretkey";
                    request.getParameter(paramName);
                    userParams.put(paramName, AesCipher.encrypt(key, request.getParameter(paramName).getBytes(StandardCharsets.UTF_8)));
                }else {
                    userParams.put(paramName, request.getParameter(paramName));
                }
            }
            User user = userService.saveUser(userParams);
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher(JSPPagePath.MAIN_PAGE);
            dispatcher.forward(request, response);
        }else {
            List<Message> messages= result.getResultMessages();
            request.setAttribute("errorMessages", messages);
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher(JSPPagePath.REG_PAGE);
            dispatcher.forward(request, response);
        }
    }

    private ValidationResult validateRegForm(String userLogin, String userPassword, String userEmail){
        CompositeValidator validator = new CompositeValidator();
        validator.add(new UserLoginValidator(userLogin));
        validator.add(new UserPasswordValidator(userPassword));
        validator.add(new UserEmailValidator(userEmail));
        return validator.validate();
    }
}



package by.epam.labproject.createmypc.controller.command.impl;
import by.epam.labproject.createmypc.controller.command.Command;
import by.epam.labproject.createmypc.service.ServiceFactory;
import by.epam.labproject.createmypc.service.UserService;
import by.epam.labproject.createmypc.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MainPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();
        RequestDispatcher dispatcher = request
                .getRequestDispatcher(JSPPagePath.MAIN_PAGE);

        request.setAttribute("user", userService.getUserByName("Malkom"));
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            //log ?????????????
        }

    }

}
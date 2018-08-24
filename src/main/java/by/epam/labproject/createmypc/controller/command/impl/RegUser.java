package by.epam.labproject.createmypc.controller.command.impl;

import by.epam.labproject.createmypc.controller.command.Command;
import by.epam.labproject.createmypc.service.ServiceFactory;
import by.epam.labproject.createmypc.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class RegUser implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();
        Map<String,String> userParams = new HashMap<String,String>();
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements())
        {
            String paramName = (String)enumeration.nextElement();
            userParams.put(paramName,request.getParameter(paramName));
        }
        String message = userService.saveUser(userParams);
        response.addHeader("message", message);
        RequestDispatcher dispatcher = request
                .getRequestDispatcher(JSPPagePath.MAIN_PAGE);

        dispatcher.forward(request, response);
    }

}

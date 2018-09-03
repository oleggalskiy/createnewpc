package by.epam.labproject.createmypc.controller.command.impl;

import by.epam.labproject.createmypc.controller.command.Command;
import by.epam.labproject.createmypc.domain.Role;
import by.epam.labproject.createmypc.domain.User;
import by.epam.labproject.createmypc.service.ServiceFactory;
import by.epam.labproject.createmypc.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserListPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();
        HttpSession session = request.getSession();
        Iterable<User> userList = userService.findAll();
        request.setAttribute("usersList",userList);

        RequestDispatcher dispatcher = request
                .getRequestDispatcher(JSPPagePath.USERLIST_PAGE);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            //log ?????????????
        }
    }
}

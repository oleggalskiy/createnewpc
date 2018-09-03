package by.epam.labproject.createmypc.controller.command.impl;

import by.epam.labproject.createmypc.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request
                .getRequestDispatcher(JSPPagePath.REG_PAGE);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            //log ?????????????
        }
    }
}

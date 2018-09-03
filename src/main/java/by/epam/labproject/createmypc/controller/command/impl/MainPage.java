package by.epam.labproject.createmypc.controller.command.impl;
import by.epam.labproject.createmypc.controller.command.Command;
import by.epam.labproject.createmypc.domain.PCBean;
import by.epam.labproject.createmypc.service.PcService;
import by.epam.labproject.createmypc.service.ServiceFactory;
import by.epam.labproject.createmypc.service.UserService;
import by.epam.labproject.createmypc.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class MainPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory factory = ServiceFactory.getInstance();
        PcService pcService = factory.getPcService();
        RequestDispatcher dispatcher = request
                .getRequestDispatcher(JSPPagePath.MAIN_PAGE);
        HttpSession session = request.getSession();
        session.setAttribute("pcList", pcService.findAll());
        try {
                        dispatcher.forward(request, response);
        } catch (ServletException | IOException  e) {
            //log ?????????????
        }

    }

}
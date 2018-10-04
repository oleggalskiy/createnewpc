package by.epam.labproject.createmypc.controller.command.impl;

import by.epam.labproject.createmypc.controller.command.Command;
import by.epam.labproject.createmypc.domain.PCBean;
import by.epam.labproject.createmypc.domain.User;
import by.epam.labproject.createmypc.service.PcService;
import by.epam.labproject.createmypc.service.ServiceFactory;
import by.epam.labproject.createmypc.service.exception.ServiceException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

public class SavePcConfig implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory factory = ServiceFactory.getInstance();
        PcService pcService = factory.getPcService();
        User author = (User) request.getSession().getAttribute("user");
        String params = request.getParameter("configPC");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PCBean pcBean = gson.fromJson(params, PCBean.class);
        pcBean.setAuthor(author);
        try {
            pcService.save(pcBean);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}

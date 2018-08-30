package by.epam.labproject.createmypc.service;

import by.epam.labproject.createmypc.service.impl.PcServiceImpl;
import by.epam.labproject.createmypc.service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final PcService pcService = new PcServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public PcService getPcService() {
        return pcService;
    }



}


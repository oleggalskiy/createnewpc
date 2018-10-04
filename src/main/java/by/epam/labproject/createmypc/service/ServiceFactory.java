package by.epam.labproject.createmypc.service;

import by.epam.labproject.createmypc.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final PcService pcService = new PcServiceImpl();
    private final CpuBeanService cpuBeanService = new CpuBeanServiceImpl();
    private final DdrBeanService ddrBeanService = new DdrBeanServiceImpl();
    private final MbBeanService mbBeanService = new MbBeanServiceImpl();
    private final VgaBeanService vgaBeanService = new VgaBeanServiceImpl();

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

    public CpuBeanService getCpuBeanService() {
        return cpuBeanService;
    }

    public DdrBeanService getDdrBeanService() {
        return ddrBeanService;
    }

    public MbBeanService getMbBeanService() {
        return mbBeanService;
    }

    public VgaBeanService getVgaBeanService() {
        return vgaBeanService;
    }
}


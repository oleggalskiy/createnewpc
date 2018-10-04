package by.epam.labproject.createmypc.dao;

import by.epam.labproject.createmypc.dao.impl.*;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO userDAO = new UserDAOImpl();
    private final PcDAO  pcDAO = new PcDAOImpl();
    private final RoleDAO roleDAO = new RoleDAOImpl();
    private final CpuDAO cpuDAO = new CpuDAOImpl();
    private final DdrDAO ddrDAO = new DdrDAOImpl();
    private final MbDAO mbDAO = new MbDAOImpl();
    private final VgaDAO vgaDAO = new VgaDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }


    public UserDAO getUserDAO() {return userDAO;}
    public PcDAO   getPcDAO() {return pcDAO;}
    public RoleDAO getRoleDAO() {return roleDAO;}
    public CpuDAO getCpuDAO() {return cpuDAO;}
    public DdrDAO getDdrDAO(){return  ddrDAO;}
    public MbDAO getMbDAO() {return mbDAO;}
    public VgaDAO getVgaDAO() {return vgaDAO;}
}

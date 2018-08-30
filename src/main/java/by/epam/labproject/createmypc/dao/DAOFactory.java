package by.epam.labproject.createmypc.dao;

import by.epam.labproject.createmypc.dao.impl.PcDAOImpl;
import by.epam.labproject.createmypc.dao.impl.UserDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO  userDAO = new UserDAOImpl();
    private final PcDAO  pcDAO = new PcDAOImpl();
    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }


    public UserDAO getUserDAO() {
        return userDAO;
    }
    public PcDAO   getPcDAO() {   return pcDAO;
    }
}

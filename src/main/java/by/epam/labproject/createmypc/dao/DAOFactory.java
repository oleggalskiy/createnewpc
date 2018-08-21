package by.epam.labproject.createmypc.dao;

import by.epam.labproject.createmypc.dao.impl.SQLUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO  userDAO = new SQLUserDAO();
    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }


    public UserDAO getUserDAO() {
        return userDAO;
    }
}

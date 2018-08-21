package by.epam.labproject.createmypc.service.impl;

import by.epam.labproject.createmypc.dao.DAOFactory;
import by.epam.labproject.createmypc.dao.UserDAO;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.domain.User;
import by.epam.labproject.createmypc.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User getUserByName(String username) {
        UserDAO dao = getDaoFromFactory();
        try {
            return dao.findByUsername(username);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private UserDAO getDaoFromFactory(){
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getUserDAO();
    }


}

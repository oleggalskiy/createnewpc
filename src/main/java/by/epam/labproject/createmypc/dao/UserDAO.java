package by.epam.labproject.createmypc.dao;

import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.domain.User;


public interface UserDAO extends CrudDAO<User> {

    User findByUsername(String username) throws DAOException;
}

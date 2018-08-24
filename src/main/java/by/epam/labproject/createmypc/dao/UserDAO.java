package by.epam.labproject.createmypc.dao;

import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.domain.User;
import com.sun.xml.internal.bind.v2.model.core.ID;

public interface UserDAO extends CrudDAO<User, ID> {

    User findByUsername(String username) throws DAOException;
}

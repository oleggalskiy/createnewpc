package by.epam.labproject.createmypc.service.impl;

import by.epam.labproject.createmypc.dao.DAOFactory;
import by.epam.labproject.createmypc.dao.UserDAO;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.domain.Role;
import by.epam.labproject.createmypc.domain.User;
import by.epam.labproject.createmypc.service.UserService;
import by.epam.labproject.createmypc.service.exception.ServiceException;

import javax.naming.Name;
import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

import static by.epam.labproject.createmypc.domain.Role.USER;


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

    @Override
    public String saveUser(Map<String, String> userParams) {
        Map<String, String> newUserParams = userParams;
        User newUser = User.newBuilder()
                .setUsername(newUserParams.get("username"))
                .setPassword(newUserParams.get("password"))
                .setFirstname(newUserParams.get("firstname"))
                .setSurname(newUserParams.get("surname"))
                .setEmail(newUserParams.get("email"))
                .setAge(newUserParams.get("age"))
                .setAddress(newUserParams.get("address"))
                .setActive(true)
                .build();

        UserDAO dao = getDaoFromFactory();
        try {
             dao.save(newUser);
        } catch (DAOException e) {
        e.printStackTrace();
    }
            if( newUser != null){
                return "User registration confirm";
            }else return "User can't be registered";
    }

    private UserDAO getDaoFromFactory() {
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getUserDAO();

    }

    @Override
    public Object findByID(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Object save(Object domain) throws ServiceException {
        UserDAO dao = getDaoFromFactory();

        return null;
    }

    @Override
    public void update(Object domain) throws ServiceException {

    }

    @Override
    public void delete(Long id) throws ServiceException {

    }

    @Override
    public Iterable<User> findAll(){
        UserDAO dao = getDaoFromFactory();
        try {
            return dao.findAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package by.epam.labproject.createmypc.service.impl;

import by.epam.labproject.createmypc.dao.DAOFactory;
import by.epam.labproject.createmypc.dao.UserDAO;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.domain.Role;
import by.epam.labproject.createmypc.domain.User;
import by.epam.labproject.createmypc.service.UserService;
import by.epam.labproject.createmypc.service.exception.ServiceException;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;



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
    public User saveUser(Map<String, String> userParams) {
        Map<String, String> newUserParams = userParams;
        User newUser;
        newUser = User.newBuilder()
                .setUsername(newUserParams.get("username"))
                .setPassword(newUserParams.get("password"))
                .setFirstname(newUserParams.get("firstname"))
                .setSurname(newUserParams.get("surname"))
                .setEmail(newUserParams.get("email"))
                .setAge(newUserParams.get("age"))
                .setAddress(newUserParams.get("address"))
                .setActive(true)
                .setRoles(Collections.singleton(Role.USER))
                .build();
        try {
            newUser = save(newUser);

            return newUser;
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return newUser;
    }


    @Override
    public User checkUser(String login, String password) throws ServiceException {
        UserDAO dao = getDaoFromFactory();
        User checkUser = null;
        try {
            checkUser =dao.checkUser(login, password);
            return checkUser;
        }catch (DAOException e){
           throw  new ServiceException("Can't do dao.checkUser()!");
        }
    }


    private UserDAO getDaoFromFactory() {
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getUserDAO();

    }

    @Override
    public Optional<User> findByID(Long id) {
        UserDAO dao = getDaoFromFactory();
        try {
            return dao.findById(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public User save(User domain) throws ServiceException {
        UserDAO dao = getDaoFromFactory();
        try {
            User saveUser = dao.save(domain);

            return saveUser;
        } catch (DAOException e) {
            e.printStackTrace();
        return null;
    }
}

    @Override
    public void update(User domain) throws ServiceException {

    }

    @Override
    public void delete(Long id) throws ServiceException {

    }

    @Override
    public Iterable<User> findAll() {
        UserDAO dao = getDaoFromFactory();
        try {
            return dao.findAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

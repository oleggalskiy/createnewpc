package by.epam.labproject.createmypc.service;

import by.epam.labproject.createmypc.domain.User;
import by.epam.labproject.createmypc.service.exception.ServiceException;

import java.util.Map;


public interface UserService extends CrudService<User>{

        User getUserByName(String username);
        User saveUser(Map<String, String> userParams);
        User checkUser(String login, String password) throws ServiceException;
}

package by.epam.labproject.createmypc.service;

import by.epam.labproject.createmypc.domain.User;

import java.util.Map;


public interface UserService extends CrudService{

        User getUserByName(String username);
        String saveUser(Map<String, String> userParams);
}

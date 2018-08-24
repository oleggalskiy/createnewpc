package by.epam.labproject.createmypc.service;

import by.epam.labproject.createmypc.service.exception.ServiceException;

import java.util.List;

public interface CrudService <T> {
    T findByID(Long id) throws ServiceException;

    T save(T domain) throws ServiceException;

    void update(T domain) throws ServiceException;

    void delete(Integer id) throws ServiceException;

    Iterable<T> findAll();
}

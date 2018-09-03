package by.epam.labproject.createmypc.service;

import by.epam.labproject.createmypc.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface CrudService <T> {
    Optional<T> findByID(Long id)  throws ServiceException;

    T save(T domain) throws ServiceException;

    void update(T domain) throws ServiceException;

    void delete(Long id) throws ServiceException;

    Iterable<T> findAll();
}

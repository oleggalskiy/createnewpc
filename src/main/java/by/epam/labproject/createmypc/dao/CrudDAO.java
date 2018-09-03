package by.epam.labproject.createmypc.dao;

import by.epam.labproject.createmypc.dao.exception.DAOException;

import java.util.Optional;

public interface CrudDAO<T> {

    T save(T entity) throws DAOException;

    Iterable<T> saveAll(Iterable<T> entities);

    Optional<T> findById(Long entity) throws DAOException ;

    Iterable<T> findAll() throws DAOException;

    long count();

    void deleteById(Long id);

    void delete(T entity);
}

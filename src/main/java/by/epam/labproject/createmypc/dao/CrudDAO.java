package by.epam.labproject.createmypc.dao;

import by.epam.labproject.createmypc.dao.exception.DAOException;

import java.util.Optional;

public interface CrudDAO<T, ID> {

    <S extends T> S save(S entity) throws DAOException;
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
    Optional findById(ID entity);
    Iterable<T> findAll() throws DAOException;
    long count();
    void deleteById(ID id);
    void delete(T entity);
}

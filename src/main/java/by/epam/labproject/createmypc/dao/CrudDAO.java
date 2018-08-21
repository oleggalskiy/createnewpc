package by.epam.labproject.createmypc.dao;

import java.util.Optional;

public interface CrudDAO<T, ID> {

    <S extends T> S save(S entity);
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
    Optional findById(ID entity);
    Iterable<T> findAll();
    long count();
    void deleteById(ID id);
    void delete(T entity);
}

package com.example.faculty.model.dao;

import java.util.List;
import java.util.Optional;

public interface GeneralDAO<T> extends AutoCloseable {
    void create(T entity);
    Optional<T> findById(long id);
    List<T> findAll();
    void update(T entity);
    void delete(long id);
    void close();
}

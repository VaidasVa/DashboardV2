package dev.todos.service;

import java.util.List;
import java.util.Optional;

public interface Service<T, ID> {
    T save(T t);
    List<T> getAll();
    Optional<T> getById(ID id);
    Optional<T> update(ID id, T t);
    boolean delete(ID id);
}

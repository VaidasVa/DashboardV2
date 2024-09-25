package dev.todos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface Controller<T, ID> {
    @PostMapping
    ResponseEntity<T> create(@RequestBody T t);

    @GetMapping("/{id}")
    ResponseEntity<T> getById(@PathVariable ID id);

    @GetMapping
    ResponseEntity<List<T>> getAll();

    @PutMapping("/{id}")
    Optional<T> update(@PathVariable ID id, @RequestBody T t);

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable ID id);
}

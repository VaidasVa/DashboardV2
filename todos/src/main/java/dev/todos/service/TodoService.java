package dev.todos.service;

import dev.todos.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    public List<Todo> getAllTodos() {
        return List.of(new Todo());
    }

    ;
}

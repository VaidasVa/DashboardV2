package dev.todos.controller;

import dev.todos.model.Todo;
import dev.todos.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }

}

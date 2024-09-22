package dev.todos.controller;

import dev.todos.model.Todo;
import dev.todos.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok().body(todoService.getAllTodos());
    }

    @PostMapping("/")
    public ResponseEntity<String> createTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
        return ResponseEntity.ok("Todo created");
    }

}

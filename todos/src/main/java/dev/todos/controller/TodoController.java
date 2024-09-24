package dev.todos.controller;


import dev.todos.model.Subtask;
import dev.todos.model.Todo;
import dev.todos.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/v1/todos")
@AllArgsConstructor
@RequiredArgsConstructor
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok().body(todoService.getAllTodos());
    }

    @PostMapping("/")
    public ResponseEntity<String> createTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
        return ResponseEntity.ok("Todo created");
    }

    @PutMapping("/subtasks/{taskId}")
    public ResponseEntity<String> addSubtask(@PathVariable String taskId,
                                             @RequestBody Subtask subtask) {
        todoService.addSubtask(taskId, subtask);
        return ResponseEntity.ok("Subtask created");
    }

}

package dev.todos.controller.impl;

import dev.todos.controller.Controller;
import dev.todos.model.Todo;
import dev.todos.service.impl.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController implements Controller<Todo, String> {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }


    @PostMapping("/{folderId}")
    public ResponseEntity<Todo> create(@RequestBody Todo todo, @PathVariable String folderId) {
        service.addTodo(todo, folderId);
        return null;
    }

    @Override
    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getById(@PathVariable String todoId) {
        return service.getById(todoId).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Todo>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Override
    @PutMapping("/{todoId}")
    public ResponseEntity<Optional<Todo>> update(@PathVariable String todoId, @RequestBody Todo todo) {
        Optional<Todo> result = service.update(todoId, todo);
        if (result.isPresent()) {
            return ResponseEntity.ok(result);
        } else return ResponseEntity.notFound().build();
    }

    @Override
    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> delete(@PathVariable String todoId) {
        if (service.delete(todoId)) {
            return ResponseEntity.noContent().build();
        } else return ResponseEntity.notFound().build();
    }
}

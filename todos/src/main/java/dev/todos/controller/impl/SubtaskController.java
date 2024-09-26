package dev.todos.controller.impl;

import dev.todos.controller.Controller;
import dev.todos.model.Subtask;
import dev.todos.service.impl.SubtaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/subtasks")
public class SubtaskController implements Controller<Subtask, Long> {

    private final SubtaskService service;

    public SubtaskController(SubtaskService service) {
        this.service = service;
    }

    @PostMapping("/{todoId}")
    public ResponseEntity<Subtask> create(@RequestBody Subtask subtask, @PathVariable String todoId) {
        service.saveSubtaskToTodo(subtask, todoId);
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Subtask> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Subtask>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Optional<Subtask>> update(@PathVariable Long id, @RequestBody Subtask subtask) {
        Optional<Subtask> response = service.update(id, subtask);
        if (response.isPresent()) {
            return ResponseEntity.ok(response);
        } else return ResponseEntity.notFound().build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return service.delete(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}

package dev.todos.controller.impl;

import dev.todos.controller.Controller;
import dev.todos.model.Subtask;
import dev.todos.service.impl.SubtaskService;
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
    public ResponseEntity<Subtask> getById(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<List<Subtask>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<Optional<Subtask>> update(Long aLong, Subtask subtask) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Long aLong) {
        return null;
    }
}

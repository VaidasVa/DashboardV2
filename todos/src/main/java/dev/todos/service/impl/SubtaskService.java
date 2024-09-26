package dev.todos.service.impl;

import dev.todos.model.Subtask;
import dev.todos.model.Todo;
import dev.todos.repository.SubtaskRepository;
import dev.todos.repository.TodoRepository;
import dev.todos.repository.dto.SubtaskDTO;
import dev.todos.repository.dto.TodoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubtaskService implements dev.todos.service.Service<Subtask, Long> {

    private final SubtaskRepository repository;
    private final TodoRepository todoRepository;
    private final ModelMapper mapper = new ModelMapper();

    public SubtaskService(SubtaskRepository repository, TodoRepository todoRepository) {
        this.repository = repository;
        this.todoRepository = todoRepository;
    }

    public void saveSubtaskToTodo(Subtask subtask, String todoId) {
        TodoDTO todoDTO = todoRepository.findById(todoId).orElse(null);
        SubtaskDTO subtaskDTO = mapper.map(subtask, SubtaskDTO.class);
        todoDTO.getSubtasks().add(subtaskDTO);
        repository.save(subtaskDTO);
        }

    @Override
    public List<Subtask> getAll() {
        return repository.findAll().stream()
                .map(item -> mapper.map(item, Subtask.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Subtask> getById(Long id) {
        return repository.findById(id).map(item -> mapper.map(item, Subtask.class));
    }

    @Override
    public Optional<Subtask> update(Long id, Subtask subtask) {
        return repository.findById(id)
                .map(dto -> {
                    dto.setTitle(subtask.getTitle());
                    repository.save(dto);
                    return Optional.of(mapper.map(dto, Subtask.class));
                })
                .orElse(Optional.empty());
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}


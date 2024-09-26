package dev.todos.service.impl;

import dev.todos.model.Subtask;
import dev.todos.repository.SubtaskRepository;
import dev.todos.repository.TodoRepository;
import dev.todos.repository.dto.SubtaskDTO;
import dev.todos.repository.dto.TodoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubtaskService implements dev.todos.service.Service<Subtask, Long> {

    private final SubtaskRepository repository;
    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public SubtaskService(SubtaskRepository repository, TodoRepository todoRepository) {
        this.repository = repository;
        this.todoRepository = todoRepository;
    }

    public void saveSubtaskToTodo(Subtask subtask, String todoId) {
        TodoDTO todoDTO = todoRepository.findById(todoId).orElse(null);
        SubtaskDTO subtaskDTO = modelMapper.map(subtask, SubtaskDTO.class);
        todoDTO.getSubtasks().add(subtaskDTO);
        repository.save(subtaskDTO);
        }

    @Override
    public List<Subtask> getAll() {
        return List.of();
    }

    @Override
    public Optional<Subtask> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Subtask> update(Long aLong, Subtask subtask) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }
}


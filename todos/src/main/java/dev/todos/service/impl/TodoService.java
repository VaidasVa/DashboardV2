package dev.todos.service.impl;

import dev.todos.model.Todo;
import dev.todos.repository.FolderRepository;
import dev.todos.repository.TodoRepository;
import dev.todos.repository.dto.FolderDTO;
import dev.todos.repository.dto.TodoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService implements dev.todos.service.Service<Todo, String> {

    private final TodoRepository repository;
    private final FolderRepository folderRepository;
    private final ModelMapper mapper = new ModelMapper();

    public TodoService(TodoRepository todoRepository, FolderRepository folderRepository) {
        this.repository = todoRepository;
        this.folderRepository = folderRepository;
    }

    public void addTodo(Todo todo, String folderId) {
        FolderDTO folderDTO = folderRepository.findById(folderId).orElse(null);
        TodoDTO todoDTO = mapper.map(todo, TodoDTO.class);
        folderDTO.getTodos().add(todoDTO);
        repository.save(todoDTO);
    }

    @Override
    public List<Todo> getAll() {
        return repository.findAll().stream().map(found -> mapper.map(found, Todo.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Todo> getById(String s) {
        return repository.findById(s).map(dto -> mapper.map(dto, Todo.class));
    }

    @Override
    public Optional<Todo> update(String s, Todo todo) {
        return repository.findById(s)
                .map(dto -> {
                    dto.setTodoName(todo.getTodoName());
                    repository.save(dto);
                    return Optional.of(mapper.map(repository.findById(s).get(), Todo.class));
                })
                .orElse(Optional.empty());
    }

    @Override
    public boolean delete(String s) {
        if (repository.existsById(s)) {
            repository.deleteById(s);
            return true;
        }
        return false;
    }
}

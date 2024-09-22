package dev.todos.service;

import dev.todos.model.Todo;
import dev.todos.repository.TodoRepository;
import dev.todos.repository.dao.TodoDAO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getAllTodos() {
        List<TodoDAO> daos = repository.findAll();
        List<Todo> todos = new ArrayList<>();
        for (TodoDAO dao : daos) {
            todos.add(mapper.map(dao, Todo.class));
        }
        return todos;
    }

    public void addTodo(Todo todo) {

        System.out.println(todo);
        System.out.println(todo.getTodoName());
        TodoDAO dao = mapper.map(todo, TodoDAO.class);
        System.out.println(dao);
        repository.save(dao);
    }
}

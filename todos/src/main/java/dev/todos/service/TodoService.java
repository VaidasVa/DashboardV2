package dev.todos.service;

import dev.todos.model.Todo;
import dev.todos.repository.TodoDAO;
import dev.todos.repository.TodosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodosRepository repository;

    ModelMapper mapper = new ModelMapper();

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
        System.out.println(todo.getTitle());
        TodoDAO dao = mapper.map(todo, TodoDAO.class);
        System.out.println(dao);
        repository.save(dao);
    }
}

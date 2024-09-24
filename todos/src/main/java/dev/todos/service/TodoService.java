package dev.todos.service;

import dev.todos.model.Subtask;
import dev.todos.model.Todo;
import dev.todos.repository.TodoRepository;
import dev.todos.repository.dao.SubtaskDAO;
import dev.todos.repository.dao.TodoDAO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository repository;
    ModelMapper mapper = new ModelMapper();

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getAllTodos() {
        List<TodoDAO> all = repository.findAll();
        List<Todo> todos = new ArrayList<>();
        for (TodoDAO todoDAO : all) {
            todos.add(mapper.map(todoDAO, Todo.class));
        }

        System.out.println(all.size());
        return todos;
    }

    public void addTodo(Todo todo) {
        TodoDAO dao = mapper.map(todo, TodoDAO.class);
        repository.save(dao);
    }

    public void addSubtask(String taskId, Subtask subtask) {
//        if (repository.existsById(taskId)) {
//            Optional<TodoDAO> dao = repository.findById(taskId);
//            dao.ifPresent((x) -> {
//                x.getSubtasks().add(mapper.map(subtask, SubtaskDAO.class));
//                repository.save(x);
//            });
        repository.findById(taskId).ifPresentOrElse(todo -> {
                    List<SubtaskDAO> subtasks = todo.getSubtasks();
                    subtasks.add(mapper.map(subtask, SubtaskDAO.class));
                    todo.setSubtasks(subtasks);
                    repository.save(todo);
                },
                () -> {
                    throw new RuntimeException("Todo not found");
                });
    }
}

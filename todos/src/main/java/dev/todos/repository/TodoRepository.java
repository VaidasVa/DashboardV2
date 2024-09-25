package dev.todos.repository;

import dev.todos.repository.dto.TodoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoDTO, String> {

}

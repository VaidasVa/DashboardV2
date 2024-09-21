package dev.todos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodosRepository extends JpaRepository<TodoDAO, UUID> {
}

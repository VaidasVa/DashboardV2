package dev.todos.repository.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.todos.model.Todo;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "todo_subtasks")
@Entity
public class TodoSubtaskDAO {

    @Id
    @UuidGenerator
    private UUID subtaskId;

    private String subtaskContent;

    @JsonIgnore
    private boolean completed;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "parent_todo_id")
    private TodoDAO parentTodo;
}

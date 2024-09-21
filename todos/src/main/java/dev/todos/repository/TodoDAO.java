package dev.todos.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Table
@Entity(name = "todo")
public class TodoDAO {

    @Id
    @UuidGenerator
    private UUID noteId;

    private String title;

    private boolean completed;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime completedAt;

    private LocalDateTime deletedAt;

    private UUID userID;

    private UUID folderId;
}

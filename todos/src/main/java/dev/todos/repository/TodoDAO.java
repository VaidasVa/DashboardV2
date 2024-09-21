package dev.todos.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Table
@Entity(name = "todo")
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDAO {

    @Id
    @UuidGenerator
    @JsonIgnore
    private UUID noteId;

    @Column
    private String title;

    @JsonIgnore
    @Column
    private boolean completed;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime completedAt;

    @JsonIgnore
    private LocalDateTime deletedAt;

    @JsonIgnore
    private UUID userID;

    @JsonIgnore
    private UUID folderId;


    @PrePersist
    public void prePersist() {
        completed = false;
    }
}

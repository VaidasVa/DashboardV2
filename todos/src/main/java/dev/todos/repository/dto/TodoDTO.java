package dev.todos.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "todos")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    @Id
    @UuidGenerator
    @Column(name= "note_id", nullable = false, updatable = false, unique = true,
    length = 36, columnDefinition = "VARCHAR(36)")
    private String todoId;

    @Column(nullable = false)
    private String todoName;

    @JsonIgnore
    @Column
    private boolean completed = false;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime completedAt = null;

    @JsonIgnore
    private LocalDateTime deletedAt = null;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SubtaskDTO> subtasks = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    private FolderDTO folder;
}

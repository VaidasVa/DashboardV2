package dev.todos.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "todos")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    @Id
    @UuidGenerator
    @Column(nullable = false, updatable = false, unique = true,
    length = 36, columnDefinition = "VARCHAR(36)")
    private String id;

    @Column
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_id")
    @JsonIgnore
    private List<SubtaskDTO> subtasks = new ArrayList<>();
}

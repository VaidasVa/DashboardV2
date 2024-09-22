package dev.todos.repository.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "todos")
@Entity
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
    @NonNull
    private String todoName;

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

    @Column(name = "user_id")
    @JsonIgnore
    private UUID userID;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parent_folder_id")
    private TodoFolderDAO parentFolder;

    @JsonIgnore
    @OneToMany(mappedBy = "parentTodo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TodoSubtaskDAO> subtasks = new ArrayList<>();



    @PrePersist
    public void prePersist() {
        completed = false;
    }
}

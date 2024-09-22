package dev.todos.repository.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.todos.model.Todo;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="todo_folders")
public class TodoFolderDAO {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID folderId;

    private String folderName;

    @JsonIgnore
    private boolean deleted;

    @JsonIgnore
    @Column(name = "user_id")
    private UUID userId;

    @JsonIgnore
    @OneToMany(mappedBy = "parentFolder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TodoDAO> todos = new ArrayList<>();
}

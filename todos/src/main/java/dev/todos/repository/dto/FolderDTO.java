package dev.todos.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "folders")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FolderDTO {

    @Id
    @UuidGenerator
    @Column(nullable = false, updatable = false, unique = true,
    length = 36, columnDefinition = "VARCHAR(36)")
    @JsonIgnore
    private String id;

    @NonNull
    @Column(nullable = false)
    private String folderName;

    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime createdAt;

    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt = null;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<TodoDTO> todos = new ArrayList<>();
}

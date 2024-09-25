package dev.todos.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "folders")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FolderDTO {

    @Id
    @UuidGenerator
    @Column(name= "folder_id", nullable = false, updatable = false, unique = true,
    length = 36, columnDefinition = "VARCHAR(36)")
    private String folderId;

    @Column(nullable = false)
    private String folderName;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt = null;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "folder_id")
    private List<TodoDTO> todos;
}

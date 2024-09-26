package dev.todos.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private String id;
    private String todoName;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime completedAt;
    private LocalDateTime deletedAt;
    private List<Subtask> subtasks;
}

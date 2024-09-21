package dev.todos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class TodoFolder {
    private UUID folderId;
    private List<Todo> todoFolder;
    private boolean deleted;
}

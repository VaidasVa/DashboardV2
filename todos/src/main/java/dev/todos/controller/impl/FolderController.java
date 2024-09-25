package dev.todos.controller.impl;

import dev.todos.controller.Controller;
import dev.todos.model.Folder;
import dev.todos.service.impl.FolderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/folders")
public class FolderController implements Controller<Folder, String> {

    private final FolderService folderService;

    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Folder> create(Folder folder) {
        Folder savedFolder = folderService.save(folder);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFolder);
    }

    @Override
    @GetMapping("/{folderId}")
    public ResponseEntity<Folder> getById(String folderId) {
        System.out.println(folderId);
        return folderService.getById(folderId)
                .map(x->ResponseEntity.ok().body(x))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Folder>> getAll() {
        return ResponseEntity.ok().body(folderService.getAll());
    }

    @Override
    @PutMapping("/{folderId}")
    public Optional<Folder> update(String folderId, Folder folder) {
        return folderService.update(folderId, folder);
    }

    @Override
    @DeleteMapping("/{folderId}")
    public ResponseEntity<String> delete(String folderId) {
        if (folderService.delete(folderId)) {
            return ResponseEntity.noContent().build();
        } else return ResponseEntity.notFound().build();


    }
}

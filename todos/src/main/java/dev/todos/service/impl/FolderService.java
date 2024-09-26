package dev.todos.service.impl;

import dev.todos.model.Folder;
import dev.todos.repository.FolderRepository;
import dev.todos.repository.dto.FolderDTO;
import dev.todos.service.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class FolderService implements Service<Folder, String> {

    private final FolderRepository repository;
    ModelMapper mapper = new ModelMapper();

    public FolderService(FolderRepository repository) {
        this.repository = repository;
    }

    public Folder save(Folder folder) {
        FolderDTO folderDTO = mapper.map(folder, FolderDTO.class);
        repository.save(folderDTO);
        return mapper.map(repository.findByFolderName(folder.getFolderName()).get(), Folder.class);
    }

    public List<Folder> getAllA() {
        List<FolderDTO> dtos = repository.findAll();
        List<Folder> limitedTodos = new ArrayList<>();
        for (FolderDTO dto : dtos) {
            Folder folder = mapper.map(dto, Folder.class);
            limitedTodos.add(folder);
        }
        return limitedTodos;
    }

    @Override
    public List<Folder> getAll() {
        return List.of();
    }

    @Override
    public Optional<Folder> getById(String s) {
        Optional<FolderDTO> dto = repository.findById(s);
        return dto.map(folderDTO -> mapper.map(folderDTO, Folder.class));
    }

    @Override
    public Optional<Folder> update(String s, Folder folder) {
        Optional<FolderDTO> dto = repository.findById(s);
        return dto.map(folderDTO -> mapper.map(folderDTO, Folder.class));
    }

    @Override
    public boolean delete(String s) {
        if (repository.existsById(s)) {
            repository.deleteById(s);
            return true;
        } else return false;
    }
}

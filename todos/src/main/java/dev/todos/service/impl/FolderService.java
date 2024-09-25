package dev.todos.service.impl;

import dev.todos.model.Folder;
import dev.todos.repository.FolderRepository;
import dev.todos.repository.dto.FolderDTO;
import dev.todos.service.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class FolderService implements Service<Folder, String> {

    private final FolderRepository repository;
    ModelMapper mapper = new ModelMapper();

    public FolderService(FolderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Folder save(Folder folder) {
        repository.save(mapper.map(folder, FolderDTO.class));
        return mapper.map(repository.findByFolderName(folder.getFolderName()).get(), Folder.class);
    }

    @Override
    public List<Folder> getAll() {
        return repository.findAll()
                .stream()
                .map(item -> mapper.map(item, Folder.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Folder> getById(String s) {
        Optional<FolderDTO> dto = repository.findById(s);
        return dto.map(folderDTO -> mapper.map(folderDTO, Folder.class));
    }

    @Override
    public Optional<Folder> update(String s, Folder folder) {
        Optional<FolderDTO> dto = repository.findById(s);
        if (dto.isPresent()) {
            dto.get().setFolderName(folder.getFolderName());
            repository.save(dto.get());
        }
        return Optional.of(mapper.map(repository.findById(s).get(), Folder.class));
    }

    @Override
    public boolean delete(String s) {
        if (repository.existsById(s)) {
            repository.deleteById(s);
            return true;
        } else return false;
    }
}

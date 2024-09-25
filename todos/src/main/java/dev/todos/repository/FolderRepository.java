package dev.todos.repository;

import dev.todos.repository.dto.FolderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FolderRepository extends JpaRepository<FolderDTO, String> {
    Optional<FolderDTO> findByFolderName(String folderName);
}

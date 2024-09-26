package dev.todos.repository;


import dev.todos.repository.dto.SubtaskDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtaskRepository extends JpaRepository<SubtaskDTO, Long> {
}

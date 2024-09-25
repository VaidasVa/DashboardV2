package dev.todos.repository.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "subtasks")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubtaskDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false, updatable = false, unique = true)
    private Long subtaskId;

    @Column
    private String title;
}

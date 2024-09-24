package dev.todos.repository.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.Random;

@Table(name = "subtasks")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubtaskDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false, updatable = false, unique = true)
    private Long subtaskId;

    @Column
    private String title;
}

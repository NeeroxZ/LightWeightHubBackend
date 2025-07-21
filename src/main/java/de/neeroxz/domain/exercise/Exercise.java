package de.neeroxz.domain.exercise;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"exercise\"")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 100)
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ExerciseCategory exerciseCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "muscle_group_id")
    private MuscleGroup muscleGroup;
}


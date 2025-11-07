package de.neeroxz.domain.workout;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"workout_set\"")
public class WorkoutSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nummer des Sets innerhalb einer Übung
    @Column(nullable = false)
    private Integer setNumber;

    // Wiederholungen
    @Column(nullable = false)
    private Integer reps;

    // Gewicht (kann null sein, falls Körpergewicht)
    @Column(precision = 10, scale = 2)
    private BigDecimal weight;

    // true = Körpergewicht (z. B. Liegestütze), false = mit Gewicht
    @Column(nullable = false)
    private Boolean isBodyWeight = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_exercise_id", nullable = false)
    private WorkoutExercise workoutExercise;
    }
package de.neeroxz.domain.training;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "training_set")
public class TrainingSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "training_exercise_id", nullable = false)
    private TrainingExercise trainingExercise;

    @NotNull
    @Column(name = "set_number", nullable = false)
    private Integer setNumber;

    @NotNull
    @Column(name = "reps", nullable = false)
    private Integer reps;

    @NotNull
    @Column(name = "weight", nullable = false, precision = 2, scale = 5)
    private BigDecimal weight;

    @ColumnDefault("false")
    @Column(name = "is_body_weight")
    private Boolean isBodyWeight;

    @NotNull
    @Column(name = "perfomed_at", nullable = false)
    private Instant perfomedAt;

}
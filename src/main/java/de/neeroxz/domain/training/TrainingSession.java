package de.neeroxz.domain.training;

import de.neeroxz.domain.user.User;
import de.neeroxz.domain.workout.Workout;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"training_session\"")
public class TrainingSession
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User userId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "workout_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Workout workout;

    @CreationTimestamp
    @Column(name = "starter_at", nullable = false, updatable = false)
    private Timestamp starterAt;

    @Column(name = "end_at")
    private Timestamp endAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "startet_at")
    private Instant startetAt;

    @NotNull
    @Column(name = "ended_at", nullable = false)
    private Instant endedAt;

}

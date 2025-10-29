package de.neeroxz.domain.training;

import de.neeroxz.domain.workout.Workout;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;

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

    private Long userId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "workout_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Workout workout;

    @CreationTimestamp
    @Column(name = "starter_at", nullable = false, updatable = false)
    private Timestamp starterAt;

    @Column(name = "end_at")
    private Timestamp endAt;

}

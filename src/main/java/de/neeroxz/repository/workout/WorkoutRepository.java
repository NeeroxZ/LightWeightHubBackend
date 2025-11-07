package de.neeroxz.repository.workout;

import de.neeroxz.domain.workout.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {
}

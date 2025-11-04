package de.neeroxz.repository.exercise;

import de.neeroxz.domain.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface: ExerciseRepository
 *
 * @author NeeroxZ
 * @date 21.07.2025
 */
public interface IExerciseRepository extends JpaRepository<Exercise, Long>
{


}
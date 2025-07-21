package de.neeroxz.repository;

import de.neeroxz.domain.exercise.Exercise;
import de.neeroxz.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
/**
 * Interface: ExerciseRepository
 *
 * @author NeeroxZ
 * @date 21.07.2025
 */
public interface IExerciseRepository extends JpaRepository<Exercise, Long>
{


}
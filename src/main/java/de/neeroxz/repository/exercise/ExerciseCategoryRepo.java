package de.neeroxz.repository.exercise;

import de.neeroxz.domain.exercise.ExerciseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseCategoryRepo extends JpaRepository<ExerciseCategory, Long> {}


package de.neeroxz.repository;

import de.neeroxz.domain.exercise.ExerciseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseCategoryRepo extends JpaRepository<ExerciseCategory, Long> {}


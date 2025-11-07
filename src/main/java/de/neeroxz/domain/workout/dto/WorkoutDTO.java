package de.neeroxz.domain.workout.dto;

import de.neeroxz.domain.exercise.dto.ExerciseDTO;
import de.neeroxz.domain.workout.WorkoutExercise;

import java.util.List;

public record WorkoutDTO(
        Long id,
        Long userId,
        String name,
        String description,
        List<WorkoutExerciseDTO> exercises
) {
}

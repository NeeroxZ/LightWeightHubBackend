package de.neeroxz.domain.workout.dto;

import de.neeroxz.domain.exercise.Exercise;
import de.neeroxz.domain.exercise.dto.ExerciseDTO;

import java.util.List;

public record WorkoutExerciseDTO(
        Long id,
        ExerciseDTO exercise,
        Integer postion,
        List<WorkoutSetDTO> sets
){
}

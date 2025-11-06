package de.neeroxz.domain.training.dto;


import java.util.List;

public record TrainingSessionDTO(
        Long id,
        Long userId,
        Long workoutId,
        List<TrainingExerciseDTO> exercises
) {}

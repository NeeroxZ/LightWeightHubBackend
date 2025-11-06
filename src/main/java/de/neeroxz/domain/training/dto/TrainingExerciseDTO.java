package de.neeroxz.domain.training.dto;

import java.util.List;

public record TrainingExerciseDTO(
        Long id,
        Long trainingSessionId,
        Long exerciseId,
        Integer position,
        List<TrainingSetDTO> sets
) {}


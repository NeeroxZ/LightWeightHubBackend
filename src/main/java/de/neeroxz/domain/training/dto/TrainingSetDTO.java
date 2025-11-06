package de.neeroxz.domain.training.dto;


import java.math.BigDecimal;
import java.time.Instant;

public record TrainingSetDTO(
        Integer id,
        Long trainingExerciseId,
        Integer setNumber,
        Integer reps,
        BigDecimal weight,
        Boolean isBodyWeight
) {}

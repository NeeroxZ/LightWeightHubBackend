package de.neeroxz.domain.workout.dto;

import java.math.BigDecimal;

public record WorkoutSetDTO(
        Integer setNumber,
        Integer reps,
        BigDecimal weight,
        Boolean isBodyWeight
) {
}

package de.neeroxz.domain.workout.dto.request;

import java.math.BigDecimal;

public record CreateTrainingSetRequest(
        int setNumber,
        int reps,
        BigDecimal weight,
        boolean isBodyWeight

) {
}

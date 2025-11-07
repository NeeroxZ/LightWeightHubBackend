package de.neeroxz.domain.workout.dto.request;

import java.util.List;

public record CreateWorkoutRequest(
        Long userID,
        String name,
        String description,
        List<CreateWorkoutExerciseRequest> exercises
) {
}

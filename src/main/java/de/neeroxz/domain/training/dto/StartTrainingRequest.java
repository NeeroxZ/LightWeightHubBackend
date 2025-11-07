package de.neeroxz.domain.training.dto;

import de.neeroxz.domain.workout.dto.WorkoutDTO;

import java.sql.Timestamp;

public record StartTrainingRequest(
        Long id,
        Long workoutId,
        WorkoutDTO workoutDTO,
        Timestamp startAt
) {
}

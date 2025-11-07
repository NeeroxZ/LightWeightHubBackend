package de.neeroxz.domain.workout.dto.request;

import java.util.List;

public record CreateWorkoutExerciseRequest(
        Long exerciseId, // Referenz auf die bestehende Übung
        int position, // Reihenfolge im Workout
        List<CreateTrainingSetRequest> sets
) {


}

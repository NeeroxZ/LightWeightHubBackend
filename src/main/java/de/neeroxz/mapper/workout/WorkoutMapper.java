package de.neeroxz.mapper.workout;

import de.neeroxz.domain.workout.Workout;
import de.neeroxz.domain.workout.dto.WorkoutDTO;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface WorkoutMapper {

    Workout toEntity(WorkoutDTO workoutDTO);

    @AfterMapping
    default void linkExercises(@MappingTarget Workout workout) {
        workout.getExercises().forEach(exercise -> exercise.setWorkout(workout));
    }

    WorkoutDTO toDto(Workout workout);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Workout partialUpdate(WorkoutDTO workoutDTO, @MappingTarget Workout workout);
}
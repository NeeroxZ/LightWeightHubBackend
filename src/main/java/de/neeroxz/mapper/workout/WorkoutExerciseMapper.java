package de.neeroxz.mapper.workout;

import de.neeroxz.domain.workout.WorkoutExercise;
import de.neeroxz.domain.workout.dto.WorkoutExerciseDTO;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface WorkoutExerciseMapper {
    WorkoutExercise toEntity(WorkoutExerciseDTO workoutExerciseDTO);

    WorkoutExerciseDTO toDto(WorkoutExercise workoutExercise);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    WorkoutExercise partialUpdate(WorkoutExerciseDTO workoutExerciseDTO, @MappingTarget WorkoutExercise workoutExercise);
}
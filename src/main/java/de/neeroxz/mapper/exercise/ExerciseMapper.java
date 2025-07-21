package de.neeroxz.mapper.exercise;

import de.neeroxz.api.v1.exercise.dto.ExerciseAddRequest;
import de.neeroxz.api.v1.exercise.dto.ExerciseDTO;
import de.neeroxz.domain.exercise.Exercise;
import de.neeroxz.domain.exercise.ExerciseCategory;
import de.neeroxz.domain.exercise.MuscleGroup;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    @Mapping(source = "exerciseCategory.id", target = "categoryId")
    @Mapping(source = "muscleGroup.id",      target = "muscleGroupId")
    ExerciseDTO toDto(Exercise entity);

    @InheritInverseConfiguration
    @Mapping(target = "exerciseCategory", ignore = true)
    @Mapping(target = "muscleGroup",      ignore = true)
    Exercise toEntity(ExerciseDTO dto);

    @Mapping(target = "exerciseCategory", ignore = true)
    @Mapping(target = "muscleGroup",      ignore = true)
    Exercise toEntity(ExerciseAddRequest dto);


}

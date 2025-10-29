package de.neeroxz.mapper.exercise;

import de.neeroxz.domain.exercise.dto.ExerciseAddRequest;
import de.neeroxz.domain.exercise.dto.ExerciseDTO;
import de.neeroxz.domain.exercise.Exercise;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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

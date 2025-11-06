package de.neeroxz.mapper.training;


import de.neeroxz.domain.training.*;
import de.neeroxz.domain.training.dto.TrainingExerciseDTO;
import de.neeroxz.domain.training.dto.TrainingSessionDTO;
import de.neeroxz.domain.training.dto.TrainingSetDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TrainingMapper {

    TrainingSessionDTO toDto(TrainingSession entity);
    TrainingSession toEntity(TrainingSessionDTO dto);

    TrainingExerciseDTO toDto(TrainingExercise entity);
    TrainingExercise toEntity(TrainingExerciseDTO dto);

    TrainingSetDTO toDto(TrainingSet entity);
    TrainingSet toEntity(TrainingSetDTO dto);
}


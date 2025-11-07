package de.neeroxz.mapper.workout;

import de.neeroxz.domain.workout.WorkoutSet;
import de.neeroxz.domain.workout.dto.WorkoutSetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkoutSetMapper {
    WorkoutSet toEntity(WorkoutSetDTO dto);
    WorkoutSetDTO toDto(WorkoutSet entity);
}


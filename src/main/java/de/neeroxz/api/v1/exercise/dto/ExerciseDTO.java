package de.neeroxz.api.v1.exercise.dto;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */
public record ExerciseDTO(
    Long id,
    String name,
    String description,
    int categoryId,
    int muscleGroupId

) {
}

package de.neeroxz.domain.exercise.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */
public record ExerciseAddRequest(
        @NotBlank String name,
        @NotBlank @Size(min = 8) String description,
        @NotNull Long categoryId,
        @NotNull Long muscleGroupId
) {}

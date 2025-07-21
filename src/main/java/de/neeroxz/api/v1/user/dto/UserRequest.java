package de.neeroxz.api.v1.user.dto;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserRequest(
        @NotBlank String username,
        @NotBlank @Size(min = 8) String password,
        @Email String email,
        @Past LocalDate birthday
) {}

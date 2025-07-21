package de.neeroxz.api.v1.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */
public record UserRegistrationRequest(
        @NotBlank String username,
        @NotBlank @Size(min = 8) String password,
        @Email String email,
        @Past LocalDate birthday
) {}

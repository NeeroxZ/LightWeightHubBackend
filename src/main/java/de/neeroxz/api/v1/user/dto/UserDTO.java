package de.neeroxz.api.v1.user.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */
public record UserDTO(
        long id,
        String username,
        String email,
        LocalDate birthday
) {
}

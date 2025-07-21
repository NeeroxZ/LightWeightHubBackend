package de.neeroxz.mapper.user;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */

import de.neeroxz.api.v1.user.dto.UserDTO;
import de.neeroxz.api.v1.user.dto.UserRegistrationRequest;
import de.neeroxz.domain.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRegistrationRequest dto);

    UserDTO toDto(User entity);
}

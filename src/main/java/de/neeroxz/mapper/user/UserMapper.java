package de.neeroxz.mapper.user;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */

import de.neeroxz.domain.user.dto.UserDTO;
import de.neeroxz.domain.user.dto.UserRegistrationRequest;
import de.neeroxz.domain.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRegistrationRequest dto);

    UserDTO toDto(User entity);
}

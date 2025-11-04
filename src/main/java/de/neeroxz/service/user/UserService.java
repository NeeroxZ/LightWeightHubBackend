package de.neeroxz.service.user;

import de.neeroxz.domain.user.dto.UserDTO;
import de.neeroxz.domain.user.dto.UserRegistrationRequest;
import de.neeroxz.domain.user.User;
import de.neeroxz.exception.DuplicateUsernameException;
import de.neeroxz.mapper.user.UserMapper;
import de.neeroxz.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    /* Registrierung */
    public UserDTO register(UserRegistrationRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            throw new DuplicateUsernameException(request.username());
        }
        System.out.println(request);
        System.out.println(userMapper.toEntity(request));
        User entity = userMapper.toEntity(request);

        userRepository.save(entity);
        return userMapper.toDto(entity);
    }

    /* User vollständig ersetzen */
    /*


    public User modify(String username, UserRequest update) {
        User entity = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found, username=" + username));

        entity.setEmail(update.email());
        entity.setBirthday(update.birthday());

        if (update.username() != null && !update.username().isBlank()) {
            entity.setUsername(update.username());
        }
        if (update.password() != null && !update.password().isBlank()) {
            entity.setPassword(update.password());
        }
        return entity;
    }
     */


    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public Optional<UserDTO> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Page<User> getAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}

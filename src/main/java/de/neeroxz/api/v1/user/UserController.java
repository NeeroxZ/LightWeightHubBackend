package de.neeroxz.api.v1.user;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */
import de.neeroxz.api.v1.user.dto.UserDTO;
import de.neeroxz.api.v1.user.dto.UserRegistrationRequest;
import de.neeroxz.mapper.UserMapper;
import de.neeroxz.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(
            @Valid @RequestBody UserRegistrationRequest request) {

        log.info("register username={}", request.username());
        UserDTO created = userService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{username}")
    public Optional<UserDTO> getByUserName(@PathVariable String username) {
        return userService.getByUsername(username);
    }
}

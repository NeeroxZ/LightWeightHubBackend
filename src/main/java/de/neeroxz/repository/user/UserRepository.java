package de.neeroxz.repository.user;

/**
 * Created by NeeroxZ
 *
 * @author : NeeroxZ
 * @date : 21.07.2025
 */
import de.neeroxz.domain.user.dto.UserDTO;
import de.neeroxz.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserDTO> findByUsername(String username);
    boolean existsByUsername(String username);
    void deleteByUsername(String username);
}

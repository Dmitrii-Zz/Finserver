package ru.finan.finserver.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.finan.finserver.user.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    boolean existsByName(String name);
    boolean existsByEmail(String email);
}

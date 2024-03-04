package ru.finan.finserver.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.finan.finserver.exceptions.model.UserNameNotFoundException;
import ru.finan.finserver.exceptions.model.UserNotFoundException;
import ru.finan.finserver.user.dto.UserDto;
import ru.finan.finserver.user.mapper.UserMapper;
import ru.finan.finserver.user.model.User;
import ru.finan.finserver.user.repository.UserRepository;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userStorage;
    private final UserMapper mapper;
    private final JwtService jwtService;

    public User createUser(User user) {
        return userStorage.save(user);
    }

    public User getByUserName(String username) {
        return userStorage.findByName(username).orElseThrow(() -> new UserNameNotFoundException(
                "Пользователь с именем '" + username + "' не найден."));
    }

    public UserDetailsService userDetailsService() {
        return this::getByUserName;
    }

    public User getCurrentUser() {
        var name = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUserName(name);
    }

    public UserDto getUserByName(Authentication authentication) {
        return mapper.toUserDto(getByUserName(authentication.getName()));
    }

    public void deleteUser(Authentication authentication) {
        Optional<User> optionalUser = userStorage.findByName(authentication.getName());

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Пользователь '" + authentication.getName() + "' не найден.");
        }

        userStorage.delete(optionalUser.get());
    }
}

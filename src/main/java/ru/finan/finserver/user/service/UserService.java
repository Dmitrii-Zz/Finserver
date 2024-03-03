package ru.finan.finserver.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.finan.finserver.exceptions.model.CannotPerformOperationException;
import ru.finan.finserver.exceptions.model.InvalidHashException;
import ru.finan.finserver.exceptions.model.PasswordException;
import ru.finan.finserver.exceptions.model.UserNameNotFoundException;
import ru.finan.finserver.user.dto.NewUserDto;
import ru.finan.finserver.user.dto.UpdateUserDto;
import ru.finan.finserver.user.mapper.UserMapper;
import ru.finan.finserver.user.model.User;
import ru.finan.finserver.user.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userStorage;
    private final UserMapper mapperUserService;

    public User createUser(User user) {
        String password;

        try {
            password = PasswordService.createHash(user.getPassword());
        } catch (CannotPerformOperationException e) {
            throw new PasswordException(e.getMessage());
        }

        user.setPassword(password);
        log.info("password: " + user.getPassword() + "\nhash: " + password);
        return userStorage.save(user);
    }

    public NewUserDto updateUser(UpdateUserDto updateUserDto) {
        User user = userStorage.getReferenceById(updateUserDto.getId());
        boolean isVerifyPassword;

        try {
            isVerifyPassword = PasswordService.verifyPassword(updateUserDto.getPassword(), user.getPassword());
        } catch (CannotPerformOperationException | InvalidHashException e) {
            throw new PasswordException(e.getMessage());
        }

        if (!isVerifyPassword) {
            throw new PasswordException("Нет доступа!");
        }

        if (updateUserDto.getName() != null) {
            user.setName(updateUserDto.getName());
        }

        User userSave = userStorage.save(user);
        return mapperUserService.toNewUserDto(userSave);
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
}

package ru.finan.finserver.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.finan.finserver.user.dto.JwtAuthenticationResponse;
import ru.finan.finserver.user.dto.NewUserDto;
import ru.finan.finserver.user.dto.SignUpRequest;
import ru.finan.finserver.user.dto.UpdateUserDto;
import ru.finan.finserver.user.service.AuthenticationService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final AuthenticationService authenticationService;

    @PostMapping
    public JwtAuthenticationResponse createUser(@RequestBody @Validated SignUpRequest request) {
        log.info("Запрос на создание юзера /с именем '" + request.getName() + "'");
        return authenticationService.signUp(request);
    }

    @PatchMapping
    public NewUserDto updateUser(@RequestBody @Validated UpdateUserDto updateUserDto) {
        log.info("Запрос на обновление пользователя");
        return null;
    }
}

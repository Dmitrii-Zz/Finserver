package ru.finan.finserver.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.finan.finserver.user.dto.*;
import ru.finan.finserver.user.service.AuthenticationService;
import ru.finan.finserver.user.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/finserver")
public class UserController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/auth/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Validated SignUpRequest request) {
        log.info("Запрос на регистрацию юзера '" + request.getName() + "'.");
        return authenticationService.signUp(request);
    }

    @PostMapping("/auth/sing-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Validated SignInRequest request) {
        log.info("Запрос на авторизацию пользователя '" + request.getName() + "'.");
        return authenticationService.signIn(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(Authentication authentication) {
        userService.deleteUser(authentication);
    }

    @GetMapping("/user")
    public UserDto getUserByName(Authentication authentication) {
        log.info("запрос пользователя: '" + authentication.getName() + "'.");
        return userService.getUserByName(authentication);
    }

    public UserDto updateUser(Authentication authentication,
                              @RequestBody @Validated UserDto userDto) {
        log.info("Запрос на обновления пользователя: '" + userDto.getName() + "'.");
        return userService.updateUser(authentication, userDto);
    }
}

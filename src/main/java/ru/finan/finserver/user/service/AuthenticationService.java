package ru.finan.finserver.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.finan.finserver.user.dto.JwtAuthenticationResponse;
import ru.finan.finserver.user.dto.SignInRequest;
import ru.finan.finserver.user.dto.SignUpRequest;
import ru.finan.finserver.user.mapper.UserMapper;
import ru.finan.finserver.user.model.Role;
import ru.finan.finserver.user.model.User;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtService jwtService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        var user = UserMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_USER);

        var jwt = jwtService.generateToken(userService.createUser(user));
        return new JwtAuthenticationResponse(jwt);
    }

    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getName(), request.getPassword()));

        var user = userService.userDetailsService().loadUserByUsername(request.getName());
        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

    public JwtAuthenticationResponse updatePassword(User user) {
        return null;
    }
}

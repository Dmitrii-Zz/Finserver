package ru.finan.finserver.user.mapper;

import org.springframework.stereotype.Component;
import ru.finan.finserver.user.dto.SignUpRequest;
import ru.finan.finserver.user.dto.UserDto;
import ru.finan.finserver.user.model.User;

@Component
public class UserMapper {

    public static User toUser(SignUpRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .id(user.getId())
                .build();
    }
}

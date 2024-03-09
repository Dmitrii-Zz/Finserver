package ru.finan.finserver.user.mapper;

import org.mapstruct.Mapper;
import ru.finan.finserver.user.dto.SignUpRequest;
import ru.finan.finserver.user.dto.UserDto;
import ru.finan.finserver.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(SignUpRequest request);

    UserDto toUserDto(User user);
}

package ru.finan.finserver.user.mapper;

import org.mapstruct.Mapper;
import ru.finan.finserver.user.dto.NewUserDto;
import ru.finan.finserver.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(NewUserDto newUserDto);
    NewUserDto toNewUserDto(User user);
}

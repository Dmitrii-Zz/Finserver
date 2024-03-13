package ru.finan.finserver.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
public class UserDto {

    private long id;

    @NotBlank(message = "Имя не может быть пустым.")
    private String name;

    @NotBlank(message = "Почта не может быть пустой.")
    @Email(message = "Неверный формат электронной почты")
    private String email;
}

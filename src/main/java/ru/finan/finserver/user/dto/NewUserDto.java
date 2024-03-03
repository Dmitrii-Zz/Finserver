package ru.finan.finserver.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class NewUserDto {

    @NotBlank(message = "Имя не может быть пустым.")
    private String name;

    @NotBlank(message = "Почта не может быть пустой.")
    @Email(message = "Неверный формат электронной почты")
    private String email;

    @NotBlank(message = "Пароль не может быть пустым.")
    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов.")
    private String password;
}

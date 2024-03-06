package ru.finan.finserver.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Запрос на регистрацию")
public class SignUpRequest {

    @Schema(description = "Имя пользователя", example = "Дмитрий")
    @NotBlank(message = "Имя пользователя не может быть пустым")
    @Size(max = 50, message = "Имя пользователя должно содержать не более 50 символов")
    private String name;

    @Schema(description = "Адрес ЭП", example = "Dimon@mail.ru")
    @Email(message = "Email адрес должен быть в формате example@example.ru")
    @Size(max = 255, message = "Email адрес не должен быть более 255 символов")
    @NotBlank(message = "Email адрес не может быть пустым")
    private String email;

    @Schema(description = "Пароль", example = "ghjuhfvvbcnjn<juf")
    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 8, max = 255, message = "Длина пароля должна быть от 8 до 255 символов")
    private String password;
}

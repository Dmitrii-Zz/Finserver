package ru.finan.finserver.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignInRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String password;
}

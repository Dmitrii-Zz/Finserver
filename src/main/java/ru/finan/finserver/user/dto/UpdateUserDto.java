package ru.finan.finserver.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String password;
}

package ru.finan.finserver.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {

    private long id;

    @Size(max = 50)
    private String name;

    @Email
    @Size(max = 100)
    private String email;

}

package ru.finan.finserver.trend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Направления траты")
public class TrendDto {

    @NotBlank
    @Schema(description = "Название направления траты", example = "Автомобиль")
    private String name;
}

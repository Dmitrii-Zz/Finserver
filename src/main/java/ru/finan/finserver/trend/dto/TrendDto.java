package ru.finan.finserver.trend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Направления траты")
public class TrendDto {

    @NotBlank
    @Schema(description = "Название направления траты", example = "Автомобиль")
    private String name;
}

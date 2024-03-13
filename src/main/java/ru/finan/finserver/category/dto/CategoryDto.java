package ru.finan.finserver.category.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Добавление категории")
public class CategoryDto {

    @NotBlank
    @Schema(description = "Название категории", example = "бензин")
    private String name;

    @Schema(description = "Это расход?", example = "false", defaultValue = "true")
    private Boolean isSpending;
}

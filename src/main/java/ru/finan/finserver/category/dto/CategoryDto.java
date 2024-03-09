package ru.finan.finserver.category.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Добавление категории")
public class CategoryDto {

    @NotBlank
    @Schema(description = "Название категории", example = "бензин")
    private String name;

    @Schema(description = "Является ли это доходом?", example = "false")
    private boolean isSpending;
}

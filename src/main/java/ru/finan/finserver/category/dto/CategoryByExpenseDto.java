package ru.finan.finserver.category.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO категории для объекта траты")
public class CategoryByExpenseDto {

    @NotBlank
    @Schema(description = "Имя категории", example = "Коммуналка")
    private String name;

    @NotNull
    @Schema(description = "Является ли категория тратой", example = "true")
    private Boolean isSpending;
}

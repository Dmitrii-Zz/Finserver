package ru.finan.finserver.finanse.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.finan.finserver.category.dto.CategoryDto;
import ru.finan.finserver.trend.model.Trend;

import java.time.LocalDateTime;

@Data
@Schema(description = "Сохранить запись")
public class ExpenseDto {

    @Schema(description = "Дата создания формируется на сервере", example = "09.03.2024")
    private LocalDateTime created;

    @NotNull
    @Schema(description = "Категория траты")
    private CategoryDto category;

    @NotNull
    @Schema(description = "Направление траты")
    private Trend trend;

    @Size(max = 255, message = "Заметка должна содержать не более 255 символов.")
    @Schema(description = "Краткая заметка", example = "Хлеб")
    private String note;

    @NotNull
    @Schema(description = "Кол-во денег", example = "99.99")
    private Double quantity;
}

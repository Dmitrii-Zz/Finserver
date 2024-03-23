package ru.finan.finserver.finanse.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import ru.finan.finserver.category.dto.CategoryByExpenseDto;

import java.time.LocalDate;

@Data
@Builder
@Schema(description = "Сохранить запись")
public class ExpenseDto {

    @Schema(description = "Дата создания формируется на сервере", example = "09.03.2024")
    private LocalDate created;

    @NotNull
    @Schema(description = "Категория траты", example = "Продукты")
    private CategoryByExpenseDto nameCategory;

    @NotNull
    @Schema(description = "Направление траты", example = "Семья")
    private String nameTrend;

    @Size(max = 255, message = "Заметка должна содержать не более 255 символов.")
    @Schema(description = "Краткая заметка", example = "Хлеб")
    private String note;

    @NotNull
    @Schema(description = "Кол-во денег", example = "99.99")
    private Double quantity;
}

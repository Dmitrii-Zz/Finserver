package ru.finan.finserver.category.mapper;

import org.springframework.stereotype.Component;
import ru.finan.finserver.category.dto.CategoryByExpenseDto;
import ru.finan.finserver.category.dto.CategoryDto;
import ru.finan.finserver.category.model.Category;

@Component
public class CategoryMapper {
    public static Category toCategory(CategoryDto categoryDto) {
        return Category.builder()
                .name(categoryDto.getName())
                .isSpending(categoryDto.getIsSpending())
                .build();
    }
    public static CategoryDto toCategoryDto(Category category) {
        return CategoryDto.builder()
                .name(category.getName())
                .isSpending(category.getIsSpending())
                .build();
    }

    public static Category toCategory(CategoryByExpenseDto categoryByExpenseDto) {
        return Category.builder()
                .name(categoryByExpenseDto.getName())
                .isSpending(categoryByExpenseDto.getIsSpending())
                .build();
    }

    public static CategoryByExpenseDto toCategoryByExpenseDto(Category category) {
        return CategoryByExpenseDto.builder()
                .name(category.getName())
                .isSpending(category.getIsSpending())
                .build();
    }
}
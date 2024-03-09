package ru.finan.finserver.category.mapper;

import org.mapstruct.Mapper;
import ru.finan.finserver.category.dto.CategoryDto;
import ru.finan.finserver.category.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryDto categoryDto);
    CategoryDto toCategoryDto(Category category);
}
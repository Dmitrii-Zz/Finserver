package ru.finan.finserver.category.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.finan.finserver.category.dto.CategoryDto;
import ru.finan.finserver.category.mapper.CategoryMapper;
import ru.finan.finserver.category.model.Category;
import ru.finan.finserver.category.repository.CategoryRepository;
import ru.finan.finserver.exceptions.model.CategoryByNameNotFoundException;
import ru.finan.finserver.user.service.UserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryStorage;
    private final UserService userService;

    public CategoryDto createCategory(CategoryDto categoryDto, Authentication authentication) {
        var category = CategoryMapper.toCategory(categoryDto);

        if (category.getIsSpending() == null) {
            category.setIsSpending(true);
        }

        category.setUser(userService.getByUserName(authentication.getName()));
        return CategoryMapper.toCategoryDto(categoryStorage.save(category));
    }

    public Category findCategoryUsers(String name, long userId) {
        Category category = categoryStorage.findByNameAndUserId(name, userId);

        if (category == null) {
            throw new CategoryByNameNotFoundException("Отсутствует категория с именем '" + name + "'.");
        }

        return category;
    }
}

package ru.finan.finserver.category.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.finan.finserver.category.dto.CategoryDto;
import ru.finan.finserver.category.service.CategoryService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/finserver/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public CategoryDto createCategory(Authentication authentication,
                                      @RequestBody @Validated CategoryDto categoryDto) {
        log.info("Запрос на создание категории '" + categoryDto.getName() + "'" + ", spending: " + categoryDto.getIsSpending());
        return categoryService.createCategory(categoryDto, authentication);
    }
}

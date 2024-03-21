package ru.finan.finserver.finanse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.finan.finserver.category.model.Category;
import ru.finan.finserver.category.service.CategoryService;
import ru.finan.finserver.finanse.dto.ExpenseDto;
import ru.finan.finserver.finanse.repository.ExpenseRepository;
import ru.finan.finserver.trend.service.TrendService;

@Service
@RequiredArgsConstructor
public class FinanceService {
    private final ExpenseRepository expenseStorage;
    private final CategoryService categoryService;
    private final TrendService trendService;

    public ExpenseDto addExpense(Authentication authentication, ExpenseDto expenseDto) {
        Category category = categoryService.findCategoryByName(expenseDto.getCategory());

        return null;
    }
}

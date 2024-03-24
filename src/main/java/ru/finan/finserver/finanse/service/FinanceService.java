package ru.finan.finserver.finanse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.finan.finserver.category.service.CategoryService;
import ru.finan.finserver.finanse.dto.ExpenseDto;
import ru.finan.finserver.finanse.mapper.ExpenseMapper;
import ru.finan.finserver.finanse.repository.ExpenseRepository;
import ru.finan.finserver.trend.service.TrendService;
import ru.finan.finserver.user.service.UserService;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FinanceService {
    private final ExpenseRepository expenseStorage;
    private final CategoryService categoryService;
    private final TrendService trendService;
    private final UserService userService;

    public ExpenseDto addExpense(Authentication authentication, ExpenseDto expenseDto) {
        var expense = ExpenseMapper.toExpense(expenseDto);
        var user = userService.getByUserName(authentication.getName());
        expense.setUser(user);

        expense.getCategory().setUser(user);
        var category = categoryService.findCategoryUsers(expense.getCategory());
        expense.setCategory(category);

        expense.setTrend(trendService.findTrendByNameAndUserId(expenseDto.getNameTrend(), user.getId()));

        if (expense.getCreated() == null) {
            expense.setCreated(LocalDate.now());
        }

        return ExpenseMapper.toExpenseDto(expenseStorage.save(expense));
    }
}

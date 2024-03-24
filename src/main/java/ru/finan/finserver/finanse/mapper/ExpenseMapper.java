package ru.finan.finserver.finanse.mapper;

import ru.finan.finserver.category.mapper.CategoryMapper;
import ru.finan.finserver.finanse.dto.ExpenseDto;
import ru.finan.finserver.finanse.model.Expense;

public class ExpenseMapper {

    public static Expense toExpense(ExpenseDto expenseDto) {
        return Expense.builder()
                .category(CategoryMapper.toCategory(expenseDto.getCategory()))
                .note(expenseDto.getNote())
                .quantity(expenseDto.getQuantity())
                .created(expenseDto.getCreated())
                .build();
    }

    public static ExpenseDto toExpenseDto(Expense expense) {
        return ExpenseDto.builder()
                .created(expense.getCreated())
                .category(CategoryMapper.toCategoryByExpenseDto(expense.getCategory()))
                .nameTrend(expense.getTrend().getName())
                .note(expense.getNote())
                .quantity(expense.getQuantity())
                .build();
    }
}

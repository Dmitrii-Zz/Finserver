package ru.finan.finserver.finanse.mapper;

import ru.finan.finserver.finanse.dto.ExpenseDto;
import ru.finan.finserver.finanse.model.Expense;

public class ExpenseMapper {

    public static Expense toExpense(ExpenseDto expenseDto) {
        return Expense.builder()
                .note(expenseDto.getNote())
                .quantity(expenseDto.getQuantity())
                .created(expenseDto.getCreated())
                .build();
    }

    public static ExpenseDto toExpenseDto(Expense expense) {
        return ExpenseDto.builder()
                .created(expense.getCreated())
                .nameCategory(expense.getCategory().getName())
                .nameTrend(expense.getTrend().getName())
                .note(expense.getNote())
                .quantity(expense.getQuantity())
                .build();
    }
}

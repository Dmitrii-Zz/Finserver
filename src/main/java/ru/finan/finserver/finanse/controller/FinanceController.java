package ru.finan.finserver.finanse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.finan.finserver.finanse.dto.ExpenseDto;

@Service
@RequiredArgsConstructor
@RequestMapping("/finance")
public class FinanceController {

    public String addSpending(@RequestBody @Validated ExpenseDto expenseDto) {
        return null;
    }
}

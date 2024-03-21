package ru.finan.finserver.finanse.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.finan.finserver.finanse.dto.ExpenseDto;
import ru.finan.finserver.finanse.service.FinanceService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/finserver")
public class FinanceController {
    private final FinanceService financeService;

    @PostMapping
    public ExpenseDto addSpending(Authentication authentication,
                                  @RequestBody @Validated ExpenseDto expenseDto) {
        log.info("Запрос на создание траты");
        return financeService.addExpense(authentication, expenseDto);
    }
}

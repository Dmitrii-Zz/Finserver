package ru.finan.finserver.finanse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.finan.finserver.user.service.PasswordService;

@Service
@RequiredArgsConstructor
public class FinanceController {
    private final PasswordService passwordService;

    public String getFinance() {
        return null;
    }
}

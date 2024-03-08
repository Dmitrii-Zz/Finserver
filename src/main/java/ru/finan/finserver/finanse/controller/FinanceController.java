package ru.finan.finserver.finanse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
@RequestMapping("/finance")
public class FinanceController {

    public String getFinance() {
        return null;
    }
}

package ru.finan.finserver.trend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.finan.finserver.trend.dto.TrendDto;
import ru.finan.finserver.trend.service.TrendService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("finserver/trend")
public class TrendController {
    private final TrendService trendService;

    @PostMapping
    public TrendDto createTrend(Authentication authentication,
                                @RequestBody @Validated TrendDto trendDto) {
        log.info("Запрос на создание направления траты: " + trendDto.getName());
        return trendService.createTrend(trendDto, authentication);
    }
}

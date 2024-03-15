package ru.finan.finserver.trend.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.finan.finserver.trend.dto.TrendDto;
import ru.finan.finserver.trend.model.Trend;
import ru.finan.finserver.trend.repository.TrendRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrendService {
    private final TrendRepository trendStorage;

    public TrendDto createTrend(TrendDto trendDto, Authentication authentication) {
        return null;
    }
}

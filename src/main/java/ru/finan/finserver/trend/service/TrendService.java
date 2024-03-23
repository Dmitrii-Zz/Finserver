package ru.finan.finserver.trend.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.finan.finserver.exceptions.model.TrendByNameNotFoundException;
import ru.finan.finserver.trend.dto.TrendDto;
import ru.finan.finserver.trend.mapper.TrendMapper;
import ru.finan.finserver.trend.model.Trend;
import ru.finan.finserver.trend.repository.TrendRepository;
import ru.finan.finserver.user.service.UserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrendService {
    private final TrendRepository trendStorage;
    private final UserService userService;

    public TrendDto createTrend(TrendDto trendDto, Authentication authentication) {
        var trend = TrendMapper.toTrend(trendDto);
        trend.setUser(userService.getByUserName(authentication.getName()));
        return TrendMapper.toTrendDto(trendStorage.save(trend));
    }

    public Trend findTrendByNameAndUserId(String name, long userId) {
        var trend = trendStorage.findByNameAndUserId(name, userId);

        if (trend == null) {
            throw new TrendByNameNotFoundException("Отсутствует направление траты с именем '" + name + "'.");
        }

        return trend;
    }
}

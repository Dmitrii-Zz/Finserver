package ru.finan.finserver.trend.mapper;

import ru.finan.finserver.trend.dto.TrendDto;
import ru.finan.finserver.trend.model.Trend;

public class TrendMapper {

    public static Trend toTrend(TrendDto trendDto) {
        return Trend.builder()
                .name(trendDto.getName())
                .build();
    }

    public static TrendDto toTrendDto(Trend trend) {
        return TrendDto.builder()
                .name(trend.getName())
                .build();
    }
}

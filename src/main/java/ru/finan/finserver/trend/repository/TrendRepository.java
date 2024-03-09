package ru.finan.finserver.trend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.finan.finserver.trend.model.Trend;

public interface TrendRepository extends JpaRepository<Trend, Long> {
}

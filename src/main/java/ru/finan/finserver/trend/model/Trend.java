package ru.finan.finserver.trend.model;

import jakarta.persistence.*;
import lombok.*;
import ru.finan.finserver.user.model.User;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trend_of_spending",
       uniqueConstraints = @UniqueConstraint(name = "name_trend_and_name_trend",
       columnNames = {"name", "user_id"}))
public class Trend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
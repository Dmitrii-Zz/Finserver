package ru.finan.finserver.finanse.model;


import jakarta.persistence.*;
import lombok.*;
import ru.finan.finserver.category.model.Category;
import ru.finan.finserver.trend.model.Trend;
import ru.finan.finserver.user.model.User;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "spending")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "trend_id", nullable = false)
    private Trend trend;

    @Column
    private String note;

    @Column
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

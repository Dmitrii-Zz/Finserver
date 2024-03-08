package ru.finan.finserver.category.model;

import jakarta.persistence.*;
import lombok.*;
import ru.finan.finserver.user.model.User;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_spending", nullable = false)
    private boolean isSpending;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

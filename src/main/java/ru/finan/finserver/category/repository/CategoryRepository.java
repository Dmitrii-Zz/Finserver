package ru.finan.finserver.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.finan.finserver.category.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

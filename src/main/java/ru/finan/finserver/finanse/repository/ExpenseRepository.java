package ru.finan.finserver.finanse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.finan.finserver.finanse.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}

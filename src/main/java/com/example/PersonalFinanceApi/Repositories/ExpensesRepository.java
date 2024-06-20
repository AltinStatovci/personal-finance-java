package com.example.PersonalFinanceApi.Repositories;

import com.example.PersonalFinanceApi.models.Enums.Category;
import com.example.PersonalFinanceApi.models.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ExpensesRepository extends JpaRepository<Expenses,Long> {

    Optional<List<Expenses>> findAllByUserId(Long userId);

    @Query("SELECT sum(e.expenses) FROM Expenses e")
    Double calculateExpenses();

        @Query(value = "SELECT sum(e.expenses) FROM Expenses e WHERE e.category=:category")
        Double calculateExpensesByCategory(Category category);

    @Query("SELECT sum(e.expenses) FROM Expenses e where e.userId =:userId")
    Double calculateUserExpenses(Long userId);

    @Query("SELECT SUM(e.expenses) FROM Expenses e WHERE e.userId = :userId AND e.category = :category")
    Double calculateUserExpensesByCategory(Long userId, Category category);



}

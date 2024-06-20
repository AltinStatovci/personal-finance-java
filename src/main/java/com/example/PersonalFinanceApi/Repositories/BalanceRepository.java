package com.example.PersonalFinanceApi.Repositories;

import com.example.PersonalFinanceApi.models.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BalanceRepository extends JpaRepository<Balance,Long> {


 Optional<List<Balance>> findAllByUserId(Long userId);

    @Query("SELECT sum(b.budget)  FROM Balance b")
    Double calculateBudget();

    @Query("SELECT SUM(b.budget) FROM Balance b WHERE b.userId =:userId ")
    Double calculateUserBudget(Long userId);


}

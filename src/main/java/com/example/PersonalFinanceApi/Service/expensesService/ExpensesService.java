package com.example.PersonalFinanceApi.Service.expensesService;


import com.example.PersonalFinanceApi.Dtos.ExpensesCardDto;
import com.example.PersonalFinanceApi.Dtos.ExpensesDto;
import com.example.PersonalFinanceApi.models.Enums.Category;

import java.util.List;

public interface ExpensesService {

    void createExpenses(ExpensesDto expense);
    void updateExpenses(Long id, ExpensesDto updateExpenses);
    void deleteExpenses(Long id);
    void deleteAll();
    ExpensesDto getExpensesById(Long id);
    List<ExpensesDto> findAll();
    List<ExpensesDto> findAllByUserId(Long userId);

    ExpensesCardDto calculateExpenses(ExpensesCardDto calculateExpenses);
    ExpensesCardDto calculateUserExpenses(ExpensesCardDto expensesCardDto , Long userId);
    ExpensesCardDto calculateExpensesByCategory(Category category);
    ExpensesCardDto calculateUserExpensesByCategory(Category category , Long userId);


}

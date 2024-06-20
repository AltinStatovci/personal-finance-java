package com.example.PersonalFinanceApi.Service.expensesService;


import com.example.PersonalFinanceApi.Dtos.ExpensesCardDto;
import com.example.PersonalFinanceApi.Dtos.ExpensesDto;
import com.example.PersonalFinanceApi.Repositories.ExpensesRepository;
import com.example.PersonalFinanceApi.mappers.ExpensesMapStructMapper;
import com.example.PersonalFinanceApi.models.Enums.Category;
import com.example.PersonalFinanceApi.models.Expenses;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpensesServiceImpl implements ExpensesService {
    private final ExpensesRepository repository;
    private final ExpensesMapStructMapper mapper;

    public ExpensesServiceImpl(ExpensesRepository repository, ExpensesMapStructMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void createExpenses(ExpensesDto expense) {
        var entity = mapper.toEntity(expense);
        repository.save(entity);

    }

    @Override
    public void updateExpenses(Long id, ExpensesDto updateExpenses) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new RuntimeException("Balance with id not found " + id);
        }

        var entity = optionalEntity.get();
        entity.setExpenses(updateExpenses.getExpenses());
        entity.setPurpose(updateExpenses.getPurpose());
        entity.setCategory(updateExpenses.getCategory());
        entity.setDate(updateExpenses.getDate());

        repository.save(entity);
    }

    @Override
    public void deleteExpenses(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public ExpensesDto getExpensesById(Long id) {
        var entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new RuntimeException("Entity with id not found " + id);
        }
        var dto = mapper.toDto(entity.get());
        return dto;
    }

    @Override
    public List<ExpensesDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public List<ExpensesDto> findAllByUserId(Long userId) {
        Optional<List<Expenses>> optionalBalances = repository.findAllByUserId(userId);
        if (optionalBalances.isPresent()) {
            return optionalBalances.get().stream().map(mapper::toDto).toList();
        } else {
            throw new RuntimeException("No Expenses found for user ID: " + userId);
        }
    }

    @Override
    public ExpensesCardDto calculateExpenses(ExpensesCardDto calculateExpensess) {
        Double totalExpenses = repository.calculateExpenses();
        totalExpenses = (totalExpenses != null) ? totalExpenses : 0.0;
            calculateExpensess.setSum(totalExpenses);

            return calculateExpensess;

    }

    @Override
    public ExpensesCardDto calculateUserExpenses(ExpensesCardDto expensesCardDto, Long userId) {
        // Assuming repository has a method to calculate expenses for a specific user
        Double userExpenses = repository.calculateUserExpenses(userId);
        userExpenses = (userExpenses != null) ? userExpenses : 0.0;

        // Set the calculated expenses for the user in the provided ExpensesCardDto object
        expensesCardDto.setSum(userExpenses);

        return expensesCardDto;

    }

    @Override
    public ExpensesCardDto calculateExpensesByCategory(Category category) {
        Double totalExpenses = repository.calculateExpensesByCategory(category);
        totalExpenses = (totalExpenses != null) ? totalExpenses : 0.0;
        var returnObj = new ExpensesCardDto();
        returnObj.setSum(totalExpenses);

        return returnObj;
    }

    @Override
    public ExpensesCardDto calculateUserExpensesByCategory(Category category, Long userId) {
        Double totalUserExpenses = repository.calculateUserExpensesByCategory(userId, category);
        totalUserExpenses = (totalUserExpenses != null) ? totalUserExpenses : 0.0;
        var returnObj = new ExpensesCardDto();
        returnObj.setSum(totalUserExpenses);

        return returnObj;
    }

}

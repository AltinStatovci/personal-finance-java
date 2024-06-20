package com.example.PersonalFinanceApi.Service.balanceService;

import com.example.PersonalFinanceApi.Dtos.BalanceCardDto;
import com.example.PersonalFinanceApi.Dtos.BalanceDto;
import com.example.PersonalFinanceApi.Repositories.BalanceRepository;
import com.example.PersonalFinanceApi.Repositories.ExpensesRepository;
import com.example.PersonalFinanceApi.mappers.BalanceMapStructMapper;
import com.example.PersonalFinanceApi.models.Balance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceServiceImpl implements BalanceService{

    private final BalanceRepository repository;
    private final ExpensesRepository expensesRepository;
    private final BalanceMapStructMapper mapper;


    public BalanceServiceImpl(BalanceRepository repository, ExpensesRepository expensesRepository, BalanceMapStructMapper mapper) {
        this.repository = repository;
        this.expensesRepository = expensesRepository;
        this.mapper = mapper;
    }

    @Override
    public void createBalance(BalanceDto balance) {

        var entity = mapper.toEntity(balance);
        repository.save(entity);

    }

    @Override
    public void updateBalance(Long id, BalanceDto updateBalance) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty()){
            throw new RuntimeException("Balance with id not found "+id);
        }
        var entity = optionalEntity.get();
        entity.setSource(updateBalance.getSource());
        entity.setBudget(updateBalance.getBudget());
        entity.setSource(updateBalance.getSource());
        entity.setDate(updateBalance.getDate());

        repository.save(entity);
    }

    @Override
    public void deleteBalance(Long id) {
        repository.deleteById(id);
    }

    @Override
    public BalanceDto getBalanceById(Long id) {
        var entity = repository.findById(id);
        if (entity.isEmpty()){
            throw new RuntimeException("Entity wiht id not found "+id);
        }
        var dto = mapper.toDto(entity.get());
        return dto;
    }

    @Override
    public List<BalanceDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public List<BalanceDto> findAllByUserId(Long userId) {
        Optional<List<Balance>> optionalBalances = repository.findAllByUserId(userId);
        if (optionalBalances.isPresent()) {
            return optionalBalances.get().stream().map(mapper::toDto).toList();
        } else {
            throw new RuntimeException("No balances found for user ID: " + userId);
        }
    }


    @Override
    public BalanceCardDto calculateBalance(BalanceCardDto calculateBalances) {
        Double totalBudget = repository.calculateBudget();
        Double totalExpenses = expensesRepository.calculateExpenses();

        // Assign totalExpenses to 0.0 if it's null
        totalExpenses = (totalExpenses != null) ? totalExpenses : 0.0;
        // Assign totalBudget to 0.0 if it's null
        totalBudget = (totalBudget != null) ? totalBudget : 0.0;

        double total = totalBudget - totalExpenses;
        calculateBalances.setSum(total);

        return calculateBalances;
    }

    @Override
    public BalanceCardDto calculateUserBalance(BalanceCardDto calculateBalance, Long userId) {
        Double totalBudget = repository.calculateUserBudget(userId);
        Double totalExpenses = expensesRepository.calculateUserExpenses(userId);

        // Assign totalExpenses to 0.0 if it's null
        totalExpenses = (totalExpenses != null) ? totalExpenses : 0.0;
        // Assign totalBudget to 0.0 if it's null
        totalBudget = (totalBudget != null) ? totalBudget : 0.0;

        double total = totalBudget - totalExpenses;
        calculateBalance.setSum(total);

        return calculateBalance;
    }


}



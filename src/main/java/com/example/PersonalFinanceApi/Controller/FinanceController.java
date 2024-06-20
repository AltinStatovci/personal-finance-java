package com.example.PersonalFinanceApi.Controller;

import com.example.PersonalFinanceApi.Dtos.BalanceCardDto;
import com.example.PersonalFinanceApi.Dtos.BalanceDto;
import com.example.PersonalFinanceApi.Dtos.ExpensesCardDto;
import com.example.PersonalFinanceApi.Dtos.ExpensesDto;
import com.example.PersonalFinanceApi.Service.balanceService.BalanceService;
import com.example.PersonalFinanceApi.Service.balanceService.BalanceServiceImpl;
import com.example.PersonalFinanceApi.Service.expensesService.ExpensesService;
import com.example.PersonalFinanceApi.models.Enums.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/finance")
@CrossOrigin(origins = "*" )

public class FinanceController {
    private final BalanceService balanceService;
    private final ExpensesService expensesService;



    public FinanceController(BalanceServiceImpl balanceService, ExpensesService expensesService) {
        this.balanceService = balanceService;
        this.expensesService = expensesService;
    }



    @GetMapping("/")
    public List<BalanceDto> getAllBalances(){
        return balanceService.findAll();
    }

    @GetMapping("/balances/{userId}")
    public List<BalanceDto> getAllUserBalance(@PathVariable Long userId){
        return balanceService.findAllByUserId(userId);

    }

    @GetMapping ("/{id}")
    public BalanceDto getBalanceById(@PathVariable Long id){
        return balanceService.getBalanceById(id);
    }
    @GetMapping("/total-budget")
    public BalanceCardDto calculateBudget(BalanceCardDto balance){
        return  balanceService.calculateBalance(balance);

    }
        @GetMapping("/total-budget/{userId}")
        public BalanceCardDto calculateUserBudget(BalanceCardDto balance , @PathVariable Long userId){
            return  balanceService.calculateUserBalance(balance , userId);

        }

    @GetMapping("/expenses")
    public List<ExpensesDto> getAllExpenses(){return expensesService.findAll();
    }

    @GetMapping("/expenses/user/{userId}")
    public List<ExpensesDto> getAllUserExpenses(@PathVariable Long userId){
        return expensesService.findAllByUserId(userId);
    }

    @GetMapping("/expenses/{id}")
    public ExpensesDto getExpensesById(@PathVariable Long id){
        return expensesService.getExpensesById(id);
    }


        @GetMapping("/expenses/total-expenses/category/{category}")
    public ExpensesCardDto getCategoryExpenses(@PathVariable String category){
        return expensesService.calculateExpensesByCategory(Category.valueOf(category.toUpperCase()));

    }
    @GetMapping("/expenses/total-expenses/{userId}/category/{category}")
    public ExpensesCardDto getUserCategoryExpenses(@PathVariable Long userId, @PathVariable String category){
        return expensesService.calculateUserExpensesByCategory(Category.valueOf(category.toUpperCase()), userId);
    }


    @GetMapping("/expenses/total-expenses")
    public ExpensesCardDto calculateExpenses(ExpensesCardDto expenses){
        return  expensesService.calculateExpenses(expenses);

    }

    @GetMapping("/expenses/total-expenses/{userId}")
    public ExpensesCardDto calculateUserExpenses(ExpensesCardDto expenses, @PathVariable Long userId) {
        return expensesService.calculateUserExpenses(expenses, userId);
    }

    @GetMapping("/categories")
    public Category[] getAllCategories() {
        return Category.values();
    }






    @PostMapping("/")
    public void addBalance(@RequestBody BalanceDto newBalance){
        balanceService.createBalance(newBalance);

    }

    @PostMapping("/expenses/")
    public void addExpenses(@RequestBody ExpensesDto newExpenses){
        expensesService.createExpenses(newExpenses);
    }


    @PutMapping("/{id}")
    public void updateBalance(@PathVariable Long id,@RequestBody BalanceDto updateBalance){
        balanceService.updateBalance(id, updateBalance);
    }

    @PutMapping("/expenses/{id}")
    public void updateExpenses(@PathVariable Long id,@RequestBody ExpensesDto updateExpenses){
        expensesService.updateExpenses(id,updateExpenses);
    }

    @DeleteMapping("/{id}")
    public void deleteBalance(@PathVariable Long id){
        balanceService.deleteBalance(id);
    }

    @DeleteMapping("/expenses/{id}")
    public void deleteExpenses(@PathVariable Long id){
        expensesService.deleteExpenses(id);
    }

    @DeleteMapping("/expenses/")
    public void deleteAllExpenses(){
        expensesService.deleteAll();
    }


}

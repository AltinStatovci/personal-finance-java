package com.example.PersonalFinanceApi.Service.balanceService;

import com.example.PersonalFinanceApi.Dtos.BalanceCardDto;
import com.example.PersonalFinanceApi.Dtos.BalanceDto;

import java.util.List;

public interface BalanceService {

   void createBalance(BalanceDto balance);
   void updateBalance(Long id, BalanceDto updateBalance);
   void deleteBalance(Long id);
   BalanceDto getBalanceById(Long id);
   List<BalanceDto> findAll();
   List<BalanceDto> findAllByUserId(Long userId);
   BalanceCardDto calculateBalance(BalanceCardDto calculateBalance);
   BalanceCardDto calculateUserBalance(BalanceCardDto calculateBalance, Long userId);




}

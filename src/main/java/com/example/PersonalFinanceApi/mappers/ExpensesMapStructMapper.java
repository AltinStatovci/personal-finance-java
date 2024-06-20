package com.example.PersonalFinanceApi.mappers;

import com.example.PersonalFinanceApi.Dtos.ExpensesCardDto;
import com.example.PersonalFinanceApi.Dtos.ExpensesDto;
import com.example.PersonalFinanceApi.models.Expenses;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "Spring")
public interface ExpensesMapStructMapper extends Cover<Expenses, ExpensesDto, ExpensesCardDto>{
    ExpensesMapStructMapper MAPPER = Mappers.getMapper(ExpensesMapStructMapper.class);
}

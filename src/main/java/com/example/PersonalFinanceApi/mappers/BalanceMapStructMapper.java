package com.example.PersonalFinanceApi.mappers;

import com.example.PersonalFinanceApi.Dtos.BalanceCardDto;
import com.example.PersonalFinanceApi.Dtos.BalanceDto;
import com.example.PersonalFinanceApi.models.Balance;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface BalanceMapStructMapper extends Cover<Balance, BalanceDto, BalanceCardDto> {

    BalanceMapStructMapper MAPPER = Mappers.getMapper(BalanceMapStructMapper.class);

}

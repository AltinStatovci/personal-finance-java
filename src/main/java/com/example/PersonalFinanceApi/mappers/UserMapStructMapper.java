package com.example.PersonalFinanceApi.mappers;

import com.example.PersonalFinanceApi.Dtos.ExpensesCardDto;
import com.example.PersonalFinanceApi.Dtos.ExpensesDto;
import com.example.PersonalFinanceApi.Dtos.UserDto;
import com.example.PersonalFinanceApi.models.Expenses;
import com.example.PersonalFinanceApi.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapStructMapper extends Cover<User, UserDto , UserDto> {
    UserMapStructMapper MAPPER = Mappers.getMapper(UserMapStructMapper.class);

}

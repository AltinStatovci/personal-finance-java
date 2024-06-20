package com.example.PersonalFinanceApi.Service.userServicel;

import com.example.PersonalFinanceApi.Dtos.ExpensesDto;
import com.example.PersonalFinanceApi.Dtos.UserDto;

import java.util.List;

public interface UserService {
    void updateUser(Long id, UserDto user);

    void deleteUser(Long id);

    boolean checkPassword( Long Id , String rawPassword);
    UserDto getUserById(Long id);
    List<UserDto> findAll();

}

package com.example.PersonalFinanceApi.Dtos;

import com.example.PersonalFinanceApi.models.Enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;


    private String firstName;


    private String lastName;


    private String email;


    private String password;


    private Role role;
}

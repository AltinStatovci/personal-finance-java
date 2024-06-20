package com.example.PersonalFinanceApi.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordCheckRequest {
    private Long id;
    private String rawPassword;

}

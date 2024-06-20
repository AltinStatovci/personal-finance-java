package com.example.PersonalFinanceApi.Dtos;

import com.example.PersonalFinanceApi.models.Enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceDto {
    private Long id;
    private Long userId;
    private Double budget;
    private String source;
    private LocalDate date;
}

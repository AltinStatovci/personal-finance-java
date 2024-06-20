package com.example.PersonalFinanceApi.Dtos;

import com.example.PersonalFinanceApi.models.Enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpensesDto {
    private Long id;
    private Long userId;
    private Double expenses;
    private String purpose;
    private Category category;
    private LocalDate date;
}

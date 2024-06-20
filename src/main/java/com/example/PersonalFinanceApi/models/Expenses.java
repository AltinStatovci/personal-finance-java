package com.example.PersonalFinanceApi.models;

import com.example.PersonalFinanceApi.infrastructure.validation.LessToCurrentDate;
import com.example.PersonalFinanceApi.infrastructure.validation.MinLocalDateTimeValidation;
import com.example.PersonalFinanceApi.models.Enums.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Min(value = 0, message = "Value cannot be less than 0")
    @NotNull
    @Column(nullable = false)
    private Double expenses;

    private String purpose;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

//    @MinLocalDateTimeValidation(year = 2020)
//    @LessToCurrentDate
    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}

package com.example.PersonalFinanceApi.models;

import com.example.PersonalFinanceApi.infrastructure.validation.LessToCurrentDate;
import com.example.PersonalFinanceApi.infrastructure.validation.MinLocalDateTimeValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "balances")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Min(value = 0, message = "Value cannot be less than 0")
    @Column(nullable = false)
    private Double budget;

    private String source;

//   @LessToCurrentDate
//   @MinLocalDateTimeValidation(year = 2024, month = 1, day = 1)
    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}

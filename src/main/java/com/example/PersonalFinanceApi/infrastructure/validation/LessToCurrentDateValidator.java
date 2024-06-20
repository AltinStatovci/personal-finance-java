package com.example.PersonalFinanceApi.infrastructure.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class LessToCurrentDateValidator implements ConstraintValidator<LessToCurrentDate, LocalDateTime> {
    @Override
    public void initialize(LessToCurrentDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDateTime localDateTime, ConstraintValidatorContext constraintValidatorContext) {
        return localDateTime.isBefore(LocalDateTime.now()) ;
    }
}

package com.app.tutorial.springbootschoolwebcustomauthentication.validations;

import com.app.tutorial.springbootschoolwebcustomauthentication.annotation.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {

    private List<String> weakPasswords;

    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
        weakPasswords = Arrays.asList("123456", "password", "qwerty");
    }

    @Override
    public boolean isValid(String passwordField, ConstraintValidatorContext constraintValidatorContext) {
        return passwordField != null && !(weakPasswords.contains(passwordField));
    }
}

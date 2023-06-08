package com.app.tutorial.springbootschoolwebonetomany_manytoone.annotation;

import com.app.tutorial.springbootschoolwebonetomany_manytoone.validations.PasswordStrengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {
    String message() default "Please choose a strong pasword";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

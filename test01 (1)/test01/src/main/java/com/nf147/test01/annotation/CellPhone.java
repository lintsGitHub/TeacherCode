package com.nf147.test01.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CellPhoneValidator.class)
public @interface CellPhone {
    String message() default "不是合法的手机编号，应该是11位";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class CellPhoneValidator implements ConstraintValidator<CellPhone, String> {
    @Override
    public void initialize(CellPhone constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && Pattern.matches("^[0-9]{11}$", value);
    }
}

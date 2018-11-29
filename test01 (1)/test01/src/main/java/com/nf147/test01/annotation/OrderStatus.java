package com.nf147.test01.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.constraints.NotEmpty;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotEmpty
@Constraint(validatedBy =  OrderStatusValidator.class )
public @interface OrderStatus {
    String message() default "不是合法的状态，只能是 created/paid/shipped/closed 中的一个";

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

class OrderStatusValidator implements ConstraintValidator<OrderStatus, String> {
    @Override
    public void initialize(OrderStatus constraintAnnotation) {
    }

    @Override
    public boolean isValid(String status, ConstraintValidatorContext context) {
        return Arrays.asList("created", "paid22", "shipped", "closed").contains(status);
    }
}
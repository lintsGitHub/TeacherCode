package com.nf147.test01.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =  PriceRangeValidator.class )
public @interface PriceRange {
    String message() default "价格不合理";
    float min() default 0;
    float max() default 10000;

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

class PriceRangeValidator implements ConstraintValidator<PriceRange, Float> {
    private float min, max;

    @Override
    public void initialize(PriceRange constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Float price, ConstraintValidatorContext context) {
        // 记载数据库，外部 xml
        return price >= min && price <= max;
    }
}
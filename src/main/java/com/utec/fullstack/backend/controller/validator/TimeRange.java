package com.utec.fullstack.backend.controller.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = TimeRangeValidator.class)
public @interface TimeRange {

    String message() default "startsAt should be greater than {greaterThan} and lower than endsAt";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

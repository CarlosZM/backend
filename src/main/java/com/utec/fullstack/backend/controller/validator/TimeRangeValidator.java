package com.utec.fullstack.backend.controller.validator;

import com.utec.fullstack.backend.controller.request.Course;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import java.time.LocalDateTime;

public class TimeRangeValidator implements ConstraintValidator<TimeRange, Course> {

    @Override
    public boolean isValid(Course course, ConstraintValidatorContext constraintValidatorContext) {
        if (course == null) {
            return true;
        }

        if (course.getStart() == null || course.getEnd() == null) {
            return true;
        }

        if (course.getEnd().isAfter(course.getStart())) {
            return true;
        } else {
            HibernateConstraintValidatorContext hibernateContext =
                    constraintValidatorContext.unwrap(HibernateConstraintValidatorContext.class);
            hibernateContext
                    .addMessageParameter("greaterThan", LocalDateTime.now())
                    .buildConstraintViolationWithTemplate(hibernateContext.getDefaultConstraintMessageTemplate())
                    .addConstraintViolation();
            return false;
        }
    }
}

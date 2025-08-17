package org.gfg.JBDL8_DigitalLibrary.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = StudentAgeValidator.class)
public @interface ValidAge {

       String message() default  "Age should not be less than 18";
       int age() default 18;

       Class<?>[] groups() default {};

       Class<? extends Payload>[] payload() default {};
}

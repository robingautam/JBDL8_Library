package org.gfg.JBDL8_DigitalLibrary.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public  class StudentAgeValidator implements ConstraintValidator<ValidAge,String> {

    int minAge;

    @Override
    public void initialize(ValidAge constraintAnnotation) {
        this.minAge = constraintAnnotation.age();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       if (s == null || s.length() != 10){
           return false;
       }

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate userDob = LocalDate.parse(s,dateTimeFormatter);
        Period period = Period.between(userDob,localDate);

        return period.getYears()>=minAge;
    }
}

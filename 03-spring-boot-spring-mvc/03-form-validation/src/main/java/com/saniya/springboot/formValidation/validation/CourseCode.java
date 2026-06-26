package com.saniya.springboot.formValidation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = CourseCodeConstraintValidator.class) //business logic will be in CourseCodeConstraintValidator class
@Target({ElementType.METHOD,ElementType.FIELD}) ///  the annotation can be applied on method as well as field
@Retention(RetentionPolicy.RUNTIME)//it will be checked at runtime
public @interface CourseCode {

    //declare parameters with default value
    public String value() default "LUV";
    public String message() default "must start with LUV";

    //define default groups
    public Class<?>[] groups() default {};

    //define default payload
    public Class<? extends Payload>[] payload() default {};
}

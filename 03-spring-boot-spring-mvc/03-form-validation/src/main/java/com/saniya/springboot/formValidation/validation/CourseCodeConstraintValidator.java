package com.saniya.springboot.formValidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator <CourseCode,String>{

    private String coursePreffix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePreffix=theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {


        boolean result ;

        if(theCode != null)
         result = theCode.startsWith(coursePreffix);
        else result=true;
        return result;
    }


}

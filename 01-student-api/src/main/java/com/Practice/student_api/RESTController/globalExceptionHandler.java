package com.Practice.student_api.RESTController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//@ControllerAdvice for global handling
@ControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler
    //exception handler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
        //create error response
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMesssage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //generic excption handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleGenericException(Exception e){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMesssage(e.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}

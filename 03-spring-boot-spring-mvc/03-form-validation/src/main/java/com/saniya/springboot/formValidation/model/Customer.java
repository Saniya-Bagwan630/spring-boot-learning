package com.saniya.springboot.formValidation.model;

import com.saniya.springboot.formValidation.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String fName;
    private String lName;

    @NotNull(message = "is required")
    @Min(value = 0 , message="must be greater then or equal to 0")
    @Max(value = 5, message = "must be less than or equal to 5")
    private Integer passes;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message="must contain 5 digits/characters")
    private String postalCode;

    @CourseCode(value = "SAN" , message = "must start with SAN")
    private String courseCode;

    public Customer(){}

    public String getfName() {
        return fName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setPasses(Integer passes) {
        this.passes = passes;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }
}

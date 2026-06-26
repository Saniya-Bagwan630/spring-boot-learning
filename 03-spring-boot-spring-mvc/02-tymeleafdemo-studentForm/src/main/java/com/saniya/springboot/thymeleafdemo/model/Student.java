package com.saniya.springboot.thymeleafdemo.model;

import java.util.List;

public class Student {
    private String fName;
    private String lName;
    private String country;
    private String favouriteLang;
    private List<String> favouriteOS;
    public Student() {}


    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getCountry() {
        return country;
    }

    public String getFavouriteLang() {
        return favouriteLang;
    }

    public List<String> getFavouriteOS() {
        return favouriteOS;
    }

    public void setFavouriteOS(List<String> favouriteOS) {
        this.favouriteOS = favouriteOS;
    }

    public void setFavouriteLang(String favouriteLang) {
        this.favouriteLang = favouriteLang;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

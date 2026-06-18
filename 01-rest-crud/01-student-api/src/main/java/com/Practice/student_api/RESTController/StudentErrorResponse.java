package com.Practice.student_api.RESTController;

public class StudentErrorResponse {

    //responce fields
    private int status;
    private String messsage;
    private long timestamp;

    //constructors

    public StudentErrorResponse(){}

    public StudentErrorResponse(int status, String messsage, long timestamp) {
        this.status = status;
        this.messsage = messsage;
        this.timestamp = timestamp;
    }

    //getters

    public int getStatus() {
        return status;
    }

    public String getMesssage() {
        return messsage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    //setters
    public void setStatus(int status) {
        this.status = status;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

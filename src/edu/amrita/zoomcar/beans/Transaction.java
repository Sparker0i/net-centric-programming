package edu.amrita.zoomcar.beans;

import java.util.Date;

public class Transaction {
    private String userId;
    private Integer carId;
    private Date startDate , endDate , dateOfRequest;

    public static final String
        USER_ID = "USER_ID",
        CAR_ID = "CAR_ID",
        START_DATE = "START_DATE",
        END_DATE = "END_DATE",
        DATE_OF_REQUEST = "DATE_OF_REQUEST";


    public Transaction(String userId, Integer carId, Date startDate, Date endDate, Date dateOfRequest) {
        this.userId = userId;
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dateOfRequest = dateOfRequest;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(Date dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }
}

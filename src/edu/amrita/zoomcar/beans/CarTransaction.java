package edu.amrita.zoomcar.beans;

import java.util.Date;

public class CarTransaction {
    private String company, model, version, userId;
    private Integer carId;
    private Date dateOfRequest, startDate, endDate;
    private Double cost,  costPerDay;

    public Double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public static final String
            COMPANY = "CAR.COMPANY",
            MODEL = "CAR.MODEL",
            VERSION = "CAR.VERSION",
            CAR_ID = "CAR.CAR_ID",
            TRANSACTION_CAR_ID = "TRANSACTION.CAR_ID",
            START_DATE = "TRANSACTION.START_DATE",
            END_DATE = "TRANSACTION.END_DATE",
            DATE_OF_REQUEST = "TRANSACTION.DATE_OF_REQUEST",
            COST = "COST",
            COST_PER_DAY = "CAR.COST_PER_DAY",
            USER_ID = "TRANSACTION.USER_ID";

    public CarTransaction() {

    }

    public CarTransaction(String company, String model, String version, String userId, Integer carId, Date dateOfRequest, Date startDate, Date endDate, Double cost, Double costPerDay) {
        this.company = company;
        this.model = model;
        this.version = version;
        this.userId = userId;
        this.carId = carId;
        this.dateOfRequest = dateOfRequest;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
        this.costPerDay = costPerDay;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public Date getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(Date dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
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
}

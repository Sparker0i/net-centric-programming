package edu.amrita.zoomcar.beans;

public class Car {
    private Integer carId;
    private Float costPerDay;
    private String numberPlate, company, model, version, color, fuelType, carType, gearType;
    private Boolean ac, leatherSeats, sunroof;

    public static final String
            CAR_ID = "CAR_ID",
            COST_PER_DAY = "COST_PER_DAY",
            NUMBER_PLATE = "NUMBER_PLATE",
            COMPANY = "COMPANY",
            MODEL = "MODEL",
            VERSION = "VERSION",
            COLOR = "COLOR",
            FUEL_TYPE = "FUEL_TYPE",
            CAR_TYPE = "CAR_TYPE",
            GEAR_TYPE = "GEAR_TYPE",
            AC = "AC",
            LEATHER_SEATS = "LEATHER_SEATS",
            SUNROOF = "SUNROOF";

    public Car() {

    }

    public Car(Integer carId, String numberPlate, String company, String model, String version, String color, String fuelType, String gearType, Boolean ac, Boolean leatherSeats, Boolean sunroof, String carType, Float costPerDay) {
        this.carId = carId;
        this.numberPlate = numberPlate;
        this.company = company;
        this.model = model;
        this.version = version;
        this.color = color;
        this.fuelType = fuelType;
        this.gearType = gearType;
        this.ac = ac;
        this.leatherSeats = leatherSeats;
        this.sunroof = sunroof;
        this.carType = carType;
        this.costPerDay = costPerDay;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Float getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Float costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public Boolean getAc() {
        return ac;
    }

    public void setAc(Boolean ac) {
        this.ac = ac;
    }

    public Boolean getLeatherSeats() {
        return leatherSeats;
    }

    public void setLeatherSeats(Boolean leatherSeats) {
        this.leatherSeats = leatherSeats;
    }

    public Boolean getSunroof() {
        return sunroof;
    }

    public void setSunroof(Boolean sunroof) {
        this.sunroof = sunroof;
    }
}

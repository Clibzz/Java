package com.nhlstenden.highCourt;

import java.time.LocalDate;

public class Car implements Item {
    private String brand;
    private double travelledDistance; //in kilometers
    private LocalDate productionDate;

    public Car(String brand, double travelledDistance, LocalDate productionDate) {
        this.brand = brand;
        this.travelledDistance = travelledDistance;
        this.productionDate = productionDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(double travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String getDescription() {
        return "Car description";
    }

    @Override
    public LocalDate getProductionDate() {
        return this.productionDate;
    }

    @Override
    public double getValue() {
        double value = 0;
        if (this.brand.equals("Lamborghini")) {
            value += 5000;
        } else {
            LocalDate threeYearsAgo = LocalDate.now().minusYears(3).plusDays(1);
            if (this.productionDate.isAfter(threeYearsAgo)) {
                value += 2000;
            } else {
                value += 1000;
            }
        }
        value -= Math.ceil(this.travelledDistance / 1000) * 50;
        return value;
    }
}

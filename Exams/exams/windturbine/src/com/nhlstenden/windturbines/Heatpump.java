package com.nhlstenden.windturbines;

public class Heatpump extends SmartController {
    private double currentTemperature;
    private Windturbine windturbine;

    public Heatpump(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public void addSmartDevice(Heatpump heatpump) {
        this.addSmartHeatpump(heatpump);
    }

    public double getCurrentTemperature() {
        return this.currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public double generateHeat() {
        try {
            double kWh = this.windturbine.calcGeneratedEnergy();
            this.currentTemperature += kWh * 0.23;
            return kWh * 0.23;
        } catch (OverloadException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public String sumUpData() {
        return "The temperature is: " + this.currentTemperature;
    }
}

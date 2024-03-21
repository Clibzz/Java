package com.nhlstenden.highCourt;

public class Client {
    private String name;
    private double cashAmount;

    public Client(String name, double cashAmount) {
        this.name = name;
        this.cashAmount = cashAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }
}

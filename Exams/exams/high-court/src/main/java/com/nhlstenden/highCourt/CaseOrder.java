package com.nhlstenden.highCourt;

import java.util.ArrayList;

public class CaseOrder {
    private Client client;
    private double debtAmount;
    private ArrayList<Item> items;
    private Strategy strategy;

    public CaseOrder(Client client, double debtAmount) {
        this.client = client;
        this.debtAmount = debtAmount;
        this.items = new ArrayList<>();
        this.strategy = null;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    protected void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(double debtAmount) {
        this.debtAmount = debtAmount;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItems(Item item) {
        this.items.add(item);
    }

    public double calculateTotalItemValue() {
        double totalValue = 0.00;
        if (!items.isEmpty()) {
            for (Item item : items) {
                totalValue += item.getValue();
            }
        }
        return totalValue;
    }
}
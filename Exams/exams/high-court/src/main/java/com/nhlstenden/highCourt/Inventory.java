package com.nhlstenden.highCourt;

import java.time.LocalDate;

public class Inventory implements Item {
    private InventoryType type;
    private LocalDate productionDate;


    public Inventory(InventoryType type, LocalDate productionDate) {
        this.type = type;
        this.productionDate = productionDate;
    }

    public InventoryType getType() {
        return type;
    }

    public void setType(InventoryType type) {
        this.type = type;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String getDescription() {
        return "Inventory description";
    }

    @Override
    public LocalDate getProductionDate() {
        return this.productionDate;
    }

    @Override
    public double getValue() {
        double value = 0;
        LocalDate oneYearAgo = LocalDate.now().minusYears(1).plusDays(1);
        if (this.type == InventoryType.ELECTRONIC) {
            if (this.productionDate.isAfter(oneYearAgo)) {
                value += 200;
            } else {
                value += 20;
            }
        }
        if (this.type == InventoryType.KITCHENDEVICE) {
            if (this.productionDate.isAfter(oneYearAgo)) {
                value += 100;
            }
        }
        return value;
    }
}

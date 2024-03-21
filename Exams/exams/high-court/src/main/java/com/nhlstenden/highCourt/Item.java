package com.nhlstenden.highCourt;

import java.time.LocalDate;

public interface Item {
    /**
     * Get the description of an item
     * @return The description of an item
     */
    public String getDescription();

    /**
     * Get the date on which an item has been produced
     * @return The production date
     */
    public LocalDate getProductionDate();

    /**
     * Get the value in money of an item
     * @return The value in money (EUR)
     */
    public double getValue();
}

package com.nhlstenden.windturbines;

import java.util.HashSet;

public abstract class SmartController {
    private HashSet<Windturbine> smartWindturbines;
    private HashSet<Heatpump> smartHeatpumps;

    public SmartController() {
        this.smartHeatpumps = new HashSet<>();
        this.smartWindturbines = new HashSet<>();
    }

    public HashSet<Windturbine> getSmartWindturbines() {
        return this.smartWindturbines;
    }

    public void addSmartWindturbine(Windturbine smartWindturbine) {
        this.smartWindturbines.add(smartWindturbine);
    }

    public HashSet<Heatpump> getSmartHeatpumps() {
        return this.smartHeatpumps;
    }

    public void addSmartHeatpump(Heatpump smartHeatpump) {
        this.smartHeatpumps.add(smartHeatpump);
    }

    /**
     * Sum up the data that can be received from one device in a string
     * @return Summed up data of one device
     */
    public abstract String sumUpData();

    /**
     * Combine all data that has been received while using the sumUpData method in a string
     * @return All the data summed up
     */
    public String sumUpAllData() {
        String allData = "";
        for (SmartController smartController : smartWindturbines) {
            allData += sumUpData() + " | ";
        }
        for (SmartController smartController : smartHeatpumps) {
            allData += sumUpData() + " | ";
        }
        return allData;
    }
}

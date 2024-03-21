package com.nhlstenden.windturbines;

public class Windturbine extends SmartController{
    private String brand;
    private EnergyRoom energyroom;
    private WindturbineType type;
    private Heatpump heatpump;
    private int resistance;

    /**
     * Create a windturbine of the HAWT type
     * @param brand The brand of the windturbine
     * @param heatpump The heatpump of the windturbine
     * @param resistance The resistance of the gears in the windturbine
     */
    public Windturbine(String brand, Heatpump heatpump, int resistance) {
        this.brand = brand;
        this.type = WindturbineType.HAWT;
        this.heatpump = heatpump;
        this.resistance = resistance;
    }

    /**
     * Create a windturbine of the Savonius type
     * @param brand The brand of the windturbine
     * @param heatpump The heatpump of the windturbine
     */
    public Windturbine(String brand, Heatpump heatpump) {
        this.brand = brand;
        this.type = WindturbineType.SAVONIUS;
        this.heatpump = heatpump;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public WindturbineType getType() {
        return this.type;
    }

    public Heatpump getHeatpump() {
        return this.heatpump;
    }

    public void setHeatpump(Heatpump heatpump) {
        this.heatpump = heatpump;
    }

    public int getResistance() {
        return this.resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public void addSmartDevice(Windturbine windturbine) {
        if (this.type.equals(WindturbineType.SAVONIUS)) {
            this.addSmartWindturbine(windturbine);
        }
    }

    /**
     * Calculate the total amount of generated energy
     * @return The total amount of generated energy
     * @throws OverloadException
     */
    public double calcGeneratedEnergy() throws OverloadException {
        if (this.type.equals(WindturbineType.HAWT)) {
            if (this.energyroom.getWindSpeed() <= 30.0) {
                return (this.energyroom.getWindSpeed() * 0.004) / this.resistance;
            }
            throw new OverloadException();
        }
        if (this.type.equals(WindturbineType.SAVONIUS)) {
            if ((this.energyroom.getWindSpeed() * 0.002) <= 10.0) {
                return this.energyroom.getWindSpeed() * 0.002;
            }
            throw new OverloadException();
        }
        return 0;
    }

    @Override
    public String sumUpData() {
        if (this.type.equals(WindturbineType.SAVONIUS)) {
            try {
                return "Total generated kWh: " + calcGeneratedEnergy() + ", last measured wind speed: " + this.energyroom.getWindSpeed();
            } catch (OverloadException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return null;
    }
}

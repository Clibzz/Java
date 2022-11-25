public class Diesel extends Car {
    /**
     * Create a diesel car
     * @param licensePlate
     * @param chauffeur
     * @param brand
     */
    public Diesel(String licensePlate, Chauffeur chauffeur, Brand brand) {
        super(licensePlate, chauffeur, brand);
    }


    /**
     * Override the method used in Trip.getTripPrice();
     * @param distance
     * @return the price of the trip in euro's
     */
    @Override
    public double calculateTripCosts(double distance) {
        return (0.63 * distance) + getEnvironmentalSurcharge(distance);
    }

    private static double getEnvironmentalSurcharge(double distance) {
        return Math.floor(distance / 10) * 3;
    }
}

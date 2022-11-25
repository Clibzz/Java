public class Petrol extends Car {
    /**
     * Create a petrol car
     * @param licensePlate
     * @param chauffeur
     * @param brand
     */
    public Petrol(String licensePlate, Chauffeur chauffeur, Brand brand) {
        super(licensePlate, chauffeur, brand);
    }

    /**
     * Override the method used in Trip.getTripPrice();
     * @param distance
     * @return the price of the trip in euro's
     */
    @Override
    public double calculateTripCosts(double distance) {
        return 0.5 * distance;
    }
}

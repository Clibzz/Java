public class Trip {
    /**
     * The name of the trip
     */
    private String tripName;
    /**
     * The car that's used for the trip
     */
    private Car car;
    /**
     * The distance in kilometers
     */
    private double distance;

    /**
     * Create a new Trip
     * @param tripName The name of the trip
     * @param car The car that's used for the trip
     * @param distance The distance of the trip
     */
    public Trip(String tripName, Car car, double distance) {
        this.tripName = tripName;
        this.car = car;
        this.distance = distance;
    }

    /**
     * Get the car that's used for the trip
     * @return The car of the trip
     */
    public Car getCar() {
        return this.car;
    }

    /**
     * Set the car that's used for the trip
     * @param car The car of the trip
     */
    public void setCar(Car car) {
        this.car = car;
    }
    
    /**
     * Get the distance of the trip
     * @return The distance of the trip
     */
    public double getDistance() {
        return this.distance;
    }

    /**
     * Get the trip price
     * @return The trip price in euro's
     */
    public double getTripPrice() {
        return this.car.calculateTripCosts(this.distance);
    }
}

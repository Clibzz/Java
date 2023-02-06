import java.time.LocalDateTime;

public class Bicycle {
    private double travelledDistance;
    private String brand;
    private double pricePerKm;
    private LocalDateTime startTime;
    private boolean isBorrowed;
    private boolean isPaid;

    public Bicycle(String brand, double pricePerKm) {
        this.brand = brand;
        this.pricePerKm = pricePerKm;
        this.isBorrowed = false;
        this.isPaid = true;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPricePerKm() {
        return this.pricePerKm;
    }

    public void setPricePerKm(double pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public double getTravelledDistance() {
        return this.travelledDistance;
    }

    public void setTravelledDistance(double travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public boolean isBorrowed() {
        return this.isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.isBorrowed = borrowed;
    }

    public boolean isPaid() {
        return this.isPaid;
    }

    public void setPaid(boolean paid) {
        this.isPaid = paid;
    }
}

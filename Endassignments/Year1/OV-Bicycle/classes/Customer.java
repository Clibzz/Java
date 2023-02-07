import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Customer {
    private String name;
    private double debt;

    public Customer(String name) {
        this.name = name;
        this.debt = 0.00;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDebt() {
        return this.debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public void rentBicycle(Bicycle bicycle) throws IsBorrowedException {
        if (!bicycle.isBorrowed()) {
            bicycle.setStartTime(LocalDateTime.now());
            bicycle.setBorrowed(true);
            bicycle.setPaid(false);
        } else {
            throw new IsBorrowedException();
        }
    }

    public void handInBicycle(Bicycle bicycle, double distance) throws IsNotBorrowedException {
        if (bicycle.isBorrowed()) {
            bicycle.setTravelledDistance(bicycle.getTravelledDistance() + distance);
            Duration duration = Duration.between(bicycle.getStartTime(), LocalDateTime.now());
            this.debt = (duration.toHours() * 2) + (0.2 * distance);
            bicycle.setBorrowed(false);
        } else {
            throw new IsNotBorrowedException();
        }
    }

    public void payDebt(Bicycle bicycle) {
        if (this.debt > 0.00) {
            bicycle.setPaid(true);
            this.debt = 0.00;
        }
    }
}

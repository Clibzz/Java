import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Bicycle> bicycles;
    private Bicycle bicycle;

    public Company(String name) {
        this.name = name;
        this.bicycles = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Bicycle> getBicycles() {
        return this.bicycles;
    }

    public void addBicycles(Bicycle bicycle) {
        this.bicycles.add(bicycle);
    }

    public double calcTravelledDistanceOfBicycle(Bicycle bicycle) {
        return bicycle.getTravelledDistance();
    }

    public double calcTotalTravelledDistance() {
        double totalDistance = 0.0;
        for (Bicycle bicycle: bicycles) {
            totalDistance += bicycle.getTravelledDistance();
        }
        return totalDistance;
    }

    public void payDebt(Customer customer) throws NoDebtException {
        if (customer.getDebt() > 0.00) {
            customer.setDebt(0.00);
        } else {
            throw new NoDebtException();
        }
    }
}

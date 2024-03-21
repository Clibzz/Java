import java.util.HashSet;

public class Company {
    /**
     * A list of trips
     */
    private HashSet<Trip> trips;

    /**
     * Create a company
     */
    public Company() {
        this.trips =  new HashSet<>();
    }

    /**
     * Add a trip to the list
     * @param trip
     */
    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }

    /**
     * Get a trip from the list of trips
     * @param trip
     * @return A trip from the list of trips
     */
    public Trip getTripFromList(Trip trip) {
       if (checkTripInList(trip)){
            for (Trip curTrip : this.trips) {
                if (curTrip.equals(trip)) {
                    return curTrip;
                }
            }
        }
       return null;
    }

    /**
     * Check if the selected trip is in the list of trips
     * @param trip
     * @return True or false
     */
    public boolean checkTripInList(Trip trip) {
        return this.trips.contains(trip);
    }

    /**
     * Calculate the costs of a trip
     * @param trip
     * @return The costs of a trip in euro's
     */
    public double getTripCosts(Trip trip) {
        Trip curTrip = getTripFromList(trip);
        if (curTrip != null) {
            return curTrip.getTripPrice();
        } else {
            return 0;
        }
    }

    /**
     * Calculate the average distance per trip
     * @return The average distance in kilometers
     */
    public double calculateAverageDistance() {
        double distance = 0;
        if (this.trips.size() > 0) {
            for (Trip curTrip : this.trips) {
                distance += curTrip.getDistance();
            }
        }
        return distance / this.trips.size();
    }

    /**
     * Get the trip with the longest distance
     * @return The trip with the longest distance in kilometers
     */
    public Trip getLongestDistance() {
        double longestDistance = 0;
        Trip longestDistanceTrip = null;
        if (this.trips.size() > 0) {
            for (Trip curTrip : this.trips) {
                if (curTrip.getDistance() >= longestDistance) {
                    longestDistance = curTrip.getDistance();
                    longestDistanceTrip = curTrip;
                }
            }
        }
        return longestDistanceTrip;
    }

    /**
     * Calculate the total revenue of all trips
     * @return The total revenue in euro's
     */
    public double calculateTotalRevenue() {
        double totalRevenue = 0;
        if (this.trips.size() > 0) {
            for (Trip curTrip : this.trips) {
                totalRevenue += curTrip.getTripPrice();
            }
        }
        return totalRevenue;
    }

    /**
     * Add the trip costs to the revenue of the chauffeur
     * @param trip
     * @return The revenue of the chauffeur in euro's
     */
    public double addTripRevenueToChauffeur(Trip trip) {
        Trip curTrip = getTripFromList(trip);
        if (curTrip != null) {
            curTrip.getCar().getChauffeur().addRevenue(curTrip.getTripPrice());
        }
        return getTripFromList(trip).getCar().getChauffeur().getRevenue();
    }

    /**
     * Get the chauffeur with the most revenue
     * @return The chauffeur with the most revenue
     */
    public Chauffeur getChauffeurWithMostRevenue() {
        double revenue = 0;
        Chauffeur chauffeur = null;
        if (this.trips.size() > 0) {
            for (Trip curTrip : this.trips) {
                if (curTrip.getCar().getChauffeur().getRevenue() > revenue) {
                    revenue = curTrip.getCar().getChauffeur().getRevenue();
                    chauffeur = curTrip.getCar().getChauffeur();
                }
            }
        }
        return chauffeur;
    }
}

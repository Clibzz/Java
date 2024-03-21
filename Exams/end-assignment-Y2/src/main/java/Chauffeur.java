public class Chauffeur {
    /**
     * The first name of the chauffeur
     */
    private String firstName;

    /**
     * The total revenue made by the chauffeur in euro's
     */
    private double revenue;

    /**
     * Create a new chauffeur
     * @param firstName The first name of the chauffeur
     */
    public Chauffeur(String firstName) {
        checkFirstName(firstName);
        this.revenue = 0;
    }

    /**
     * Get the first name of the chauffeur
     * @return The first name of the chauffeur
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Set the first name of the chauffeur
     * @param firstName The first name of the chauffeur
     */
    public void setFirstName(String firstName) {
        checkFirstName(firstName);
    }

    /**
     * Check if the firstName field is empty
     * If true, set a default name
     * @param firstName
     * @return true or false
     */
    public boolean checkFirstName(String firstName) {
        if (firstName.isEmpty() || firstName.equals(" ")) {
            this.firstName = "BoltDriver";
            return true;
        } else {
            this.firstName = firstName;
            return false;
        }
    }

    /**
     * Add revenue to the chauffeur's total revenue in euro's
     * @param tripRevenue
     */
    public void addRevenue(double tripRevenue) {
        this.revenue += tripRevenue;
    }

    /**
     * Get the total revenue of the chauffeur
     * @return The revenue in euro's
     */
    public double getRevenue() {
        return Math.round(this.revenue * 100.0) / 100.0;
    }
}

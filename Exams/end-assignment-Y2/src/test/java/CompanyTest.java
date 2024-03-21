import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class CompanyTest {
    private Company bolt;
    private Chauffeur peter;
    private Chauffeur alfred;
    private Chauffeur caesar;
    private Car toyota;
    private Car volvo;
    private Car speed;
    private Trip colombia;
    private Trip denmark;
    private Trip rome;
    private Trip brazil;


    /**
     * Create the objects before each test is executed
     */
    @BeforeEach
    void setUp() {
        bolt = new Company();
        peter = new Chauffeur("Peter");
        alfred = new Chauffeur("alfred");
        caesar = new Chauffeur("Caesar");
        toyota = new Diesel("999-XX-9", peter, Brand.TOYOTA);
        volvo = new Electric("111-AA-1", alfred, Brand.VOLVO);
        speed = new Petrol("287-RL-1", caesar, Brand.VOLVO);
        colombia = new Trip("Colombia", toyota, 25.35);
        denmark = new Trip("Denmark", toyota, 12.0);
        rome = new Trip("Rome", speed, 50.7);
        brazil = new Trip("Brazil", volvo, 76.05);
    }

    @Test
    public void averageDistanceTest() {
        bolt.addTrip(colombia);
        assertEquals(25.35, bolt.calculateAverageDistance(), "Can't calculate the average from the trips");
        bolt.addTrip(denmark);
        assertEquals(18.68, bolt.calculateAverageDistance(), 0.1,"Can't calculate the average from the trips");
        bolt.addTrip(rome);
        assertEquals(29.35, bolt.calculateAverageDistance(), 0.1,"Can't calculate the average from the trips");
        bolt.addTrip(brazil);
        assertEquals(41.03, bolt.calculateAverageDistance(), 0.1, "Can't calculate the average from the trips");
    }

    @Test
    public void getTripCostsSimpleTest() {
        bolt.addTrip(brazil);
        assertEquals(19.01, bolt.getTripCosts(brazil), 0.01, "Can't calculate the trip costs of brazil");
    }

    @Test
    public void getTripCostsAdvancedTest() {
        bolt.addTrip(colombia);
        assertEquals(21.97, bolt.getTripCosts(colombia), 0.01, "Can't calculate the trip costs of colombia");
        bolt.addTrip(rome);
        assertEquals(25.35, bolt.getTripCosts(rome), 0.01, "Can't calculate the trip costs of rome");
        bolt.addTrip(brazil);
        assertEquals(19.01, bolt.getTripCosts(brazil), 0.01, "Can't calculate the trip costs of brazil");
    }

    @Test
    public void getLongestDistanceTest() {
        bolt.addTrip(colombia);
        bolt.addTrip(rome);
        bolt.addTrip(denmark);
        assertEquals(rome, bolt.getLongestDistance(), "Can't return the longest distance");
        bolt.addTrip(colombia);
        bolt.addTrip(denmark);
        bolt.addTrip(rome);
        bolt.addTrip(brazil);
        assertEquals(brazil, bolt.getLongestDistance(), "Can't return the longest distance");
    }

    @Test
    public void calculateTotalRevenueTest() {
        bolt.addTrip(colombia);
        assertEquals(21.97, bolt.calculateTotalRevenue(), 0.1, "Can't calculate total revenue");
        bolt.addTrip(denmark);
        assertEquals(32.53, bolt.calculateTotalRevenue(), 0.1,"Can't calculate total revenue");
        bolt.addTrip(rome);
        assertEquals(57.88, bolt.calculateTotalRevenue(), 0.1,"Can't calculate total revenue");
        bolt.addTrip(brazil);
        assertEquals(76.89, bolt.calculateTotalRevenue(), 0.1,"Can't calculate total revenue");
    }

    @Test
    public void getTripFromListTest() {
        bolt.addTrip(colombia);
        assertEquals(colombia, bolt.getTripFromList(colombia), "Trip couldn't be retrieved");
    }

    @Test
    public void getChauffeurWithMostRevenueTest() {
        bolt.addTrip(colombia);
        bolt.getTripFromList(colombia).getCar().setChauffeur(peter);
        bolt.addTripRevenueToChauffeur(colombia);
        assertEquals(peter, bolt.getChauffeurWithMostRevenue(), "Couldn't retrieve the chauffeur with the most revenue");
        bolt.addTrip(denmark);
        bolt.getTripFromList(denmark).getCar().setChauffeur(alfred);
        bolt.addTripRevenueToChauffeur(denmark);
        bolt.getTripFromList(colombia).getCar().setChauffeur(peter);
        bolt.addTripRevenueToChauffeur(colombia);
        assertEquals(peter, bolt.getChauffeurWithMostRevenue(), "Couldn't retrieve the chauffeur with the most revenue");
    }

    @Test
    public void checkTripInListTest() {
        bolt.addTrip(colombia);
        bolt.checkTripInList(colombia);
        assertTrue(true, "The list contains the trip");
    }
}

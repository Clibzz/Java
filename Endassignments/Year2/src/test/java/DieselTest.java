import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DieselTest {
    private Chauffeur peter;
    private Diesel diesel;

    @BeforeEach
    void setup() {
        peter = new Chauffeur("Peter");
        diesel = new Diesel("999-XX-9", peter, Brand.VOLVO);
    }

    @Test
    void calculateTripCosts() {
        assertEquals(93.0, diesel.calculateTripCosts(100), "Couldn't calculate trip costs");
    }

    @Test
    void calculateTripCostsAdvanced() {
        assertEquals(1.89, diesel.calculateTripCosts(3), 0.01,  "Couldn't calculate trip costs");
    }
}
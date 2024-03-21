import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetrolTest {
    private Chauffeur peter;
    private Petrol petrol;

    @BeforeEach
    void setup() {
        peter = new Chauffeur("Peter");
        petrol = new Petrol("999-XX-9", peter, Brand.VOLVO);
    }

    @Test
    void calculateTripCosts() {
        assertEquals(50.0, petrol.calculateTripCosts(100), "Couldn't calculate trip costs");
    }

    @Test
    void calculateTripCostsAdvanced() {
        assertEquals(1.50, petrol.calculateTripCosts(3), 0.01,  "Couldn't calculate trip costs");
    }
}
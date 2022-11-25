import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectricTest {
    private Chauffeur peter;
    private Electric electric;

    @BeforeEach
    void setup() {
        peter = new Chauffeur("Peter");
        electric = new Electric("999-XX-9", peter, Brand.VOLVO);
    }

    @Test
    void calculateTripCosts() {
        assertEquals(25.0, electric.calculateTripCosts(100), "Couldn't calculate trip costs");
    }

    @Test
    void calculateTripCostsAdvanced() {
        assertEquals(0.75, electric.calculateTripCosts(3), 0.01,  "Couldn't calculate trip costs");
    }
}
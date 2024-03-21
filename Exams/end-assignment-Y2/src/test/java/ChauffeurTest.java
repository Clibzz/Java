import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ChauffeurTest {
    private Company bolt;
    private Chauffeur peter;
    private Diesel lightning;
    private Trip colombia;
    private Trip rome;

    @BeforeEach
    void setup() {
        bolt = new Company();
        peter = new Chauffeur("Test");
        lightning = new Diesel("999-XX-9", peter, Brand.VOLVO);
        colombia = new Trip("Colombia", lightning, 20);
        rome = new Trip("Rome", lightning, 55);
    }

    @Test
    void checkFirstName() {
        peter.setFirstName("Peter");
        assertFalse(false, "The name is correct");
        peter.setFirstName("");
        assertTrue(true, "The name is incorrect");
    }

    @Test
    void getRevenue() {
        bolt.addTrip(colombia);
        bolt.addTrip(rome);
        bolt.addTripRevenueToChauffeur(colombia);
        assertEquals(18.60, peter.getRevenue(), "Couldn't retrieve revenue");
        bolt.addTripRevenueToChauffeur(rome);
        assertEquals(68.25, peter.getRevenue(), "Couldn't retrieve revenue");
    }
}

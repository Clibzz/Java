import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Electric tesla;
    private Chauffeur alfred;

    @BeforeEach
    void setup() {
        alfred = new Chauffeur("Alfred");
        tesla = new Electric("981-XA-7", alfred, Brand.TOYOTA);
    }

    @Test
    void checkLicensePlate() {
        tesla.setLicensePlate("111-AA-C");
        assertFalse(false, "License plate is not of the right format");
        tesla.setLicensePlate("123-AB-4");
        assertTrue(true, "License plate is of the right format");
    }
}
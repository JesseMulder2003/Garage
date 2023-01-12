package novi.springboot.Garage.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("fiat", "panda", "2004", "284435");
    }

    @Test
    void testCar_brand() {
        String expectedcar_brand = "fiat";
        String actualcar_brand = this.car.getMerk();
        assertEquals(expectedcar_brand, actualcar_brand);
    }

    @Test
    void testCar_Id() {
        String expectedKm_stand = "284435";
        String actualcar_id = this.car.getKmStand();
        assertEquals(expectedKm_stand, actualcar_id);
    }

}
package novi.springboot.Garage.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartTest {

    private Part part;

    @BeforeEach
    void setUp() {
        this.part = new Part("achterlamp", "45", "15");
    }

    @Test
    void testPart_name() {
        String expectedPart_name= "achterlamp";
        String actualPart_name = this.part.getOnderdeel();
        assertEquals(expectedPart_name, actualPart_name);
    }

    @Test
    void testPart_price() {
        String expectedPart_price= "45";
        String actualPart_price = this.part.getPrijs();
        assertEquals(expectedPart_price, actualPart_price);
    }

    @Test
    void testReparatieduur() {
        String expectedReparatieduur= "15";
        String actualReparatieduur = this.part.getReparatieduur();
        assertEquals(expectedReparatieduur, actualReparatieduur);
    }

}
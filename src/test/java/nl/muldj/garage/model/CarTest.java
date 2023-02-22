package nl.muldj.garage.model;

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

// manier 1 van directories
// domain, repository & controllers


//garage
    // model:
        // Account
        // APK
        // Appointment

    // repository:
        // AccountRepository
            //addAccount
            //getAccount
            //deleteAccount
            //updateAccount
        // APKRepository
        // AppointmentRepository

    //service
        // AccountService
            //addAccount
            //getAccount
            //deleteAccount
            //updateAccount
        // APKRepository
        // AppointmentRepository


    // controllers:
        // AccountController
            //addAccount
        // APKController
        // AppointmentController

// Front-End (website, app etc.) maakt een verzoek om account te registreren

// Front-End -> Back-End

// controllers

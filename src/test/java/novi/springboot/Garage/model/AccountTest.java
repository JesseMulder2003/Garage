package novi.springboot.Garage.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        this.account = new Account("Jesse", "Mulder", "Van asch van wijcklaan 20", "8096AH", "Oldebroek", "0612039553", "jesse200370@gmail.com", "test", "admin");
    }

    @Test
    void testAccount_first_name() {
        String expectedAccount_first_name= "Jesse";
        String actualCustomer_first_name = this.account.getFirstName();
        assertEquals(expectedAccount_first_name, actualCustomer_first_name);
    }

    @Test
    void testAccount_last_name() {
        String expectedAccount_last_name= "Mulder";
        String actualCustomer_last_name = this.account.getLastName();
        assertEquals(expectedAccount_last_name, actualCustomer_last_name);
    }

    @Test
    void testAccount_emailadres() {
        String expectedAccount_emailadres= "jesse200370@gmail.com";
        String actualCustomer_emailadres = this.account.getEmail();
        assertEquals(expectedAccount_emailadres, actualCustomer_emailadres);
    }

    @Test
    void testAccount_adres() {
        String expectedAccount_adres= "Van asch van wijcklaan 20";
        String actualCustomer_adres = this.account.getAddress();
        assertEquals(expectedAccount_adres, actualCustomer_adres);
    }

    @Test
    void testAccount_postal_code() {
        String expectedAccount_postal_code= "8096AH";
        String actualCustomer_adres = this.account.getPostalCode();
        assertEquals(expectedAccount_postal_code, actualCustomer_adres);
    }

    @Test
    void testAccount_phonenumber() {
        String expectedAccount_phonenumber= "0612039553";
        String actualCustomer_phonenumber = this.account.getPhone();
        assertEquals(expectedAccount_phonenumber, actualCustomer_phonenumber);
    }

}
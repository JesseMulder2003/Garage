package novi.springboot.Garage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customers")
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 80)
    private String voornaam;

    @Column(length = 80)
    private String achternaam;

    @Column(length = 20)
    private String telefoonnummer;

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties("customer")
    List<CustomerCar> customer_car;

    //constructor
    public Customer(){
    }

    public Customer(long id, String voornaam, String achternaam, String telefoonnummer) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.telefoonnummer = telefoonnummer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public List<CustomerCar> getCustomer_car() {
        return customer_car;
    }

    public void setCustomer_car(List<CustomerCar> customer_car) {
        this.customer_car = customer_car;
    }
}


package novi.springboot.Garage.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 80)
    private String merk;

    @Column(length = 80)
    private String autotype;

    @Column(length = 4)
    private String bouwjaar;

    @Column(length = 80)
    private String kmStand;

    @OneToMany(mappedBy = "car")
    @JsonIgnoreProperties("car")
    List<CustomerCar> customer_Car;

    //constructor
    public Car(){
    }

    public Car(long id, String merk, String autotype, String bouwjaar, String kmStand) {
        this.id = id;
        this.merk = merk;
        this.autotype = autotype;
        this.bouwjaar = bouwjaar;
        this.kmStand = kmStand;

    }

    public long getId() { return id;}

    public void setId(long id) { this.id = id; }

    public String getMerk() { return merk; }

    public void setMerk(String merk) { this.merk = merk; }

    public String getBouwjaar() { return bouwjaar; }

    public void setBouwjaar(String bouwjaar) { this.bouwjaar = bouwjaar; }

    public String getKmStand() { return kmStand; }

    public void setKmStand(String kmStand) { this.kmStand = kmStand; }

    public String getAutotype() { return autotype; }

    public void setAutotype(String autotype) { this.autotype = autotype; }

    public List<CustomerCar> getCustomer_Car() {
        return customer_Car;
    }

    public void setCustomer_Car(List<CustomerCar> customer_Car) {
        this.customer_Car = customer_Car;
    }
}

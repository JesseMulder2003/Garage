package nl.muldj.garage.model;


import javax.persistence.*;

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

    @Column
    private Long customerId;



    public Car(String merk, String autotype, String bouwjaar, String kmStand) {
        this.merk = merk;
        this.autotype = autotype;
        this.bouwjaar = bouwjaar;
        this.kmStand = kmStand;

    }

    public String toString() {
        return "Id: " + id + "\n" +
                "Merk: " + merk + "\n" +
                "Type: " + autotype + "\n" +
                "Bouwjaar: " + bouwjaar + "\n" +
                "Kilometerstand: " + kmStand + "\n" +
                "Customer Id: " + customerId;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMerk() {
        return merk;
    }

    public String getKmStand() {
        return kmStand;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}



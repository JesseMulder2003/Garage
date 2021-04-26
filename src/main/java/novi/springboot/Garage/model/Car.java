package novi.springboot.Garage.model;


import javax.persistence.*;

@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 80)
    private String merk;

    @Column(length = 4)
    private String bouwjaar;

    @Column(length = 80)
    private String kmStand;

    //constructor
    public Car(){
    }

    public Car(long id, String merk, String bouwjaar, String kmStand) {
        this.id = id;
        this.merk = merk;
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
}

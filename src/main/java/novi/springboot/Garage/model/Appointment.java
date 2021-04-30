package novi.springboot.Garage.model;

import javax.persistence.*;

@Entity
@Table(name = "Appointment")
public class Appointment {

    //connectie met auto en klant
    //datum

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 9)
    private String datum;

    public Appointment(){

    }

    public Appointment(long id, String datum) {
        this.id = id;
        this.datum = datum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}

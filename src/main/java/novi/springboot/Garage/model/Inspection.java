package novi.springboot.Garage.model;

import javax.persistence.*;

@Entity
@Table(name = "Inspection")
public class Inspection {

    //datum van keuring
    //status van de keuring(goedgekeurd/reparaties nodig)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 80)
    private String status_keuring;
}

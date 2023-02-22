package nl.muldj.garage.model;

import javax.persistence.*;

@Entity
@Table(name = "Repair")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long repair_id;

    @Column(length = 80)
    private String repair_date;

    @Column(length = 80)
    private String repair_status;
}


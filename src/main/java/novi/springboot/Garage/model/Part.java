package novi.springboot.Garage.model;

import javax.persistence.*;

@Entity
@Table(name = "Part")
public class Part {

    //onderdelen aanmaken
    //prijs van onderdeel toeveogen
    //id van onderdeel
    //(reparatieduur)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 80)
    private String onderdeel;

    @Column(length = 80)
    private String prijs;

    @Column(length = 80)
    private String reparatieduur;

    public Part(){

    }

    public Part(long id, String onderdeel, String prijs, String reparatieduur) {
        this.id = id;
        this.onderdeel = onderdeel;
        this.prijs = prijs;
        this.reparatieduur = reparatieduur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOnderdeel() {
        return onderdeel;
    }

    public void setOnderdeel(String onderdeel) {
        this.onderdeel = onderdeel;
    }

    public String getPrijs() {
        return prijs;
    }

    public void setPrijs(String prijs) {
        this.prijs = prijs;
    }

    public String getReparatieduur() {
        return reparatieduur;
    }

    public void setReparatieduur(String reparatieduur) {
        this.reparatieduur = reparatieduur;
    }
}

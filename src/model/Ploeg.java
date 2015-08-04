package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OEM on 3/08/2015.
 */
@Entity
@Table(name="T_PLOEG")
public class Ploeg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String naam;
    private Integer stamnummer;
    private Integer punten;
    private int aantalGespeeldeMatchen;

    @OneToMany
    @JoinColumn(name="ploeg_id")
    private List<Speler> spelers;

    public Ploeg() {
        this.spelers = new ArrayList<Speler>();
    }

    public Ploeg(String naam){
        this.naam = naam;
        this.spelers = new ArrayList<Speler>();
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Integer getStamnummer() {
        return stamnummer;
    }

    public void setStamnummer(Integer stamnummer) {
        this.stamnummer = stamnummer;
    }



    public List<Speler> getSpelers() {
        return spelers;
    }

    public void setSpelers(List<Speler> spelers) {
        this.spelers = spelers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addSpeler(Speler speler){
        this.spelers.add(speler);
    }

    public Integer getAantalGespeeldeMatchen() {
        return aantalGespeeldeMatchen;
    }

    public void setAantalGespeeldeMatchen(Integer aantalGespeeldeMatchen) {
        this.aantalGespeeldeMatchen = aantalGespeeldeMatchen;
    }
}

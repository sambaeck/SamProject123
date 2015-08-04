package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OEM on 3/08/2015.
 */
@Entity
@Table(name="T_AFDELING")
public class Afdeling {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String naam;

    @OneToMany
    @JoinColumn(name="afdeling_id")
    private List<Ploeg> ploegen;

    public Afdeling() {
        this.ploegen = new ArrayList<Ploeg>();
    }

    public Afdeling(String naam){
        this.ploegen = new ArrayList<Ploeg>();
        this.naam = naam;
    }

    public void addPloeg(Ploeg ploeg){
        this.ploegen.add(ploeg);
    }

    public List<Ploeg> getPloegen() {
        return ploegen;
    }

    public void setPloegen(List<Ploeg> ploegen) {
        this.ploegen = ploegen;
    }
}

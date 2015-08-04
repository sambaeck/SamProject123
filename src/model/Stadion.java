package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by OEM on 3/08/2015.
 */
@Entity
@Table(name="T_STADION")
public class Stadion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    @JoinColumn(name="stadion_id")
    private List<Ploeg> ploegen;

    public Stadion() {
    }

    public void addPloeg(Ploeg ploeg){
        this.ploegen.add(ploeg);
    }
}

package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OEM on 3/08/2015.
 */
@Entity
@Table(name = "T_WEDSTRIJD")
public class Wedstrijd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "T_WEDSTRIJD_SCHEIDSRECHTER",
            joinColumns = {@JoinColumn(name = "wedstrijd_id")},
            inverseJoinColumns = {@JoinColumn(name = "scheidsrechter_id")}
    )
    private List<Scheidsrechter> scheidsrechters;

    @ManyToMany
    @JoinTable(
            name = "T_WEDSTRIJD_PLOEG",
            joinColumns = {@JoinColumn(name = "wedstrijd_id")},
            inverseJoinColumns = {@JoinColumn(name = "ploeg_id")}
    )
    private List<Ploeg> ploegen;

    @OneToMany
    @JoinColumn(name = "wedstrijd_id")
    private List<Gebeurtenis> gebeurtenissen;

    public Wedstrijd() {
        this.ploegen= new ArrayList<Ploeg>();
        this.scheidsrechters = new ArrayList<Scheidsrechter>();
    }

    public void addPloegen(Ploeg p, Ploeg o){
        this.ploegen.add(p);
        this.ploegen.add(o);
    }

    public void addGebeurtenis(Gebeurtenis g) {
        this.gebeurtenissen.add(g);
    }



}

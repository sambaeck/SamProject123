package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by OEM on 3/08/2015.
 */
@Entity
@Table(name="T_GEBEURTENIS")
public class Gebeurtenis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private GebeurtenisType gebeurtenisType;


    @ManyToOne
    @JoinColumn(name="speler_id")
    private Speler speler;

    public Gebeurtenis() {
    }

    public Gebeurtenis(GebeurtenisType gebeurtenisType, Speler speler) {
        this.gebeurtenisType = gebeurtenisType;
        this.speler = speler;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }
}

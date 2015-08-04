package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by OEM on 3/08/2015.
 */
@Entity
@Table(name="T_SCHEIDSRECHTER")
public class Scheidsrechter{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Date geboorteDatum;
    private String adres;

    @Enumerated(EnumType.STRING)
    private ScheidsrechterRol rol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(Date geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public ScheidsrechterRol getRol() {
        return rol;
    }

    public void setRol(ScheidsrechterRol rol) {
        this.rol = rol;
    }



   


}


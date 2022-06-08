package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.VechicleState;
import com.example.masfinalbackend.enums.VechicleType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "Pojazd")
public class Pojazd {

    private static Set<String> numeryRejestracyjne;

    public Pojazd() {

    }

    public Pojazd(String nrRejestracyjny, String marka, String model, VechicleType typ){
        this.numerRejestracyjny = nrRejestracyjny;
        this.marka = marka;
        this.model = model;
        this.typ = typ;
        this.stan = VechicleState.GOTOWY;
    }

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    private String numerRejestracyjny; //unique

    private String marka;

    private String model;

    @OneToMany
    private List<Dostawa> dostawy;

    @Enumerated
    private VechicleType typ;

    @Enumerated
    private VechicleState stan;

    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }

    public void setNumerRejestracyjny(String numerRejestracyjny) {
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VechicleType getTyp() {
        return typ;
    }

    public void setTyp(VechicleType typ) {
        this.typ = typ;
    }

    public VechicleState getStan() {
        return stan;
    }

    public void setStan(VechicleState stan) {
        this.stan = stan;
    }
}

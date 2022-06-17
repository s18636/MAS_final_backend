package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.VechicleState;
import com.example.masfinalbackend.enums.VechicleType;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "pojazd")
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pojazdId;

    public void setPojazdId(Long id) {
        this.pojazdId = id;
    }
    public Long getPojazdId() {
        return pojazdId;
    }

    private String numerRejestracyjny; //unique

    private String marka;

    private String model;

    @OneToMany(mappedBy = "pojazd")
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

    public static Set<String> getNumeryRejestracyjne() {
        return numeryRejestracyjne;
    }

    public static void setNumeryRejestracyjne(Set<String> numeryRejestracyjne) {
        Pojazd.numeryRejestracyjne = numeryRejestracyjne;
    }

    public List<Dostawa> getDostawy() {
        return dostawy;
    }

    public void setDostawy(List<Dostawa> dostawy) {
        this.dostawy = dostawy;
    }
}

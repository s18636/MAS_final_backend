package com.example.masfinalbackend.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name="PracownikPlacowki")
public class PracownikPlacowki extends Pracownik {

    public PracownikPlacowki(String imie, String nazwisko, String idSeries, String stanowisko){
        super(imie, nazwisko, idSeries);
        this.stanowisko = stanowisko;
    }

    public PracownikPlacowki() {

    }

    private String stanowisko;

    @OneToMany
    private List<PracownikPlacowki> podwładni;

    @ManyToOne
    private PracownikPlacowki przelozony;

    @OneToMany
    private List<Przesylka> przesylki;

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }
}

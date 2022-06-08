package com.example.masfinalbackend.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name="pracownikPlacowki")
public class PracownikPlacowki extends Pracownik {

    public PracownikPlacowki(String imie, String nazwisko, String idSeries, String stanowisko){
        super(imie, nazwisko, idSeries);
        this.stanowisko = stanowisko;
    }

    public PracownikPlacowki() {

    }

    private String stanowisko;

    @OneToMany(mappedBy = "przelozony")
    private List<PracownikPlacowki> podwladni;

    @ManyToOne
    @JoinColumn(name = "id")
    private PracownikPlacowki przelozony;

    @OneToMany(mappedBy = "pracownikPlacowki")
    private List<Przesylka> przesylki;

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public List<PracownikPlacowki> getPodwladni() {
        return podwladni;
    }

    public void setPodwladni(List<PracownikPlacowki> podwladni) {
        this.podwladni = podwladni;
    }

    public PracownikPlacowki getPrzelozony() {
        return przelozony;
    }

    public void setPrzelozony(PracownikPlacowki przelozony) {
        this.przelozony = przelozony;
    }

    public List<Przesylka> getPrzesylki() {
        return przesylki;
    }

    public void setPrzesylki(List<Przesylka> przesylki) {
        this.przesylki = przesylki;
    }
}

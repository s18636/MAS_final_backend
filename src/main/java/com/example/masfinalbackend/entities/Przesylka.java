package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.PackageState;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Przesylka")
//https://thorben-janssen.com/complete-guide-inheritance-strategies-jpa-hibernate/#Joined
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Przesylka {

    private long id;


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    private String nadawca;
    private String odbiorca;

    private PackageState statusPrzesylki;

    private Date dataPrzyjecia;
    private Date dataDostarczenia;


    public Przesylka() {

    }

    public Przesylka(String nadawca, String odbiorca) {
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.statusPrzesylki = PackageState.OCZEKUJACA_NA_WYDANIE;
    }

    @ManyToOne
    private Adres adresNadawcy;

    @ManyToOne
    private Adres adresOdbiorcy;

    @ManyToOne
    private Dostawa dostawa;

    @ManyToOne
    private PracownikPlacowki pracownikPlacowki;

    @Transient
    public abstract double getCena();


    @Basic
    public String getNadawca() {
        return nadawca;
    }

    public void setNadawca(String nadawca) {
        this.nadawca = nadawca;
    }

    @Basic
    public String getOdbiorca() {
        return odbiorca;
    }

    public void setOdbiorca(String odbiorca) {
        this.odbiorca = odbiorca;
    }

    public PackageState getStatusPrzesylki() {
        return statusPrzesylki;
    }

    public void setStatusPrzesylki(PackageState statusPrzesylki) {
        this.statusPrzesylki = statusPrzesylki;
    }

    public Date getDataPrzyjecia() {
        return dataPrzyjecia;
    }

    public void setDataPrzyjecia(Date dataPrzyjecia) {
        this.dataPrzyjecia = dataPrzyjecia;
    }

    public Date getDataDostarczenia() {
        return dataDostarczenia;
    }

    public void setDataDostarczenia(Date dataDostarczenia) {
        this.dataDostarczenia = dataDostarczenia;
    }

    @Override
    public String toString() {
        return "Paczka{" +
                "nadawca=" + getNadawca() +
                ", odbiorca=" + getOdbiorca() +
                ", cena=" + getCena() +
                '}';
    }

}
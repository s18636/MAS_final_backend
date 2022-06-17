package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.PackageState;

import javax.persistence.*;
import java.util.Date;

@Entity(name="przesylka")
//https://thorben-janssen.com/complete-guide-inheritance-strategies-jpa-hibernate/#Joined
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Przesylka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long przesylkaId;

    public long getPrzesylkaId() {
        return przesylkaId;
    }

    private void setPrzesylkaId(long id) {
        this.przesylkaId = id;
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
    @JoinColumn(name="adres_id", updatable = false, insertable = false, nullable = false)
    private Adres adresNadawcy;

    @ManyToOne
    @JoinColumn(name="adres_id", updatable = false, insertable = false, nullable = false)
    private Adres adresOdbiorcy;

    @ManyToOne
    @JoinColumn(name = "dostawa_id")
    private Dostawa dostawa;

    @ManyToOne
    @JoinColumn(name = "pracownik_id")
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

    public Adres getAdresNadawcy() {
        return adresNadawcy;
    }

    public void setAdresNadawcy(Adres adresNadawcy) {
        this.adresNadawcy = adresNadawcy;
    }

    public Adres getAdresOdbiorcy() {
        return adresOdbiorcy;
    }

    public void setAdresOdbiorcy(Adres adresOdbiorcy) {
        this.adresOdbiorcy = adresOdbiorcy;
    }

    public Dostawa getDostawa() {
        return dostawa;
    }

    public void setDostawa(Dostawa dostawa) {
        this.dostawa = dostawa;
    }

    public PracownikPlacowki getPracownikPlacowki() {
        return pracownikPlacowki;
    }

    public void setPracownikPlacowki(PracownikPlacowki pracownikPlacowki) {
        this.pracownikPlacowki = pracownikPlacowki;
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
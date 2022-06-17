package com.example.masfinalbackend.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name="adres")
public class Adres {

    public Adres() {
    }
    public Adres(String ulica, String numerMieszkania, String kodPocztowy, String miasto) {
        this.ulica = ulica;
        this.numerMieszkania = numerMieszkania;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adres_id;

    public void setAdres_id(Long id) {
        this.adres_id = id;
    }
    public Long getAdres_id() {
        return adres_id;
    }

    private String ulica;

    private String numerMieszkania;

    private String kodPocztowy;

    private String miasto;

    @ManyToOne
    @JoinColumn(name = "pracownik_id")
    private Pracownik pracownik;

    @OneToMany(mappedBy = "adresNadawcy")
    private List<Przesylka> wychodzace;

    @OneToMany(mappedBy = "adresOdbiorcy")
    private List<Przesylka> przychodzace;

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumerMieszkania() {
        return numerMieszkania;
    }

    public void setNumerMieszkania(String numerMieszkania) {
        this.numerMieszkania = numerMieszkania;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public List<Przesylka> getWychodzace() {
        return wychodzace;
    }

    public void setWychodzace(List<Przesylka> wychodzace) {
        this.wychodzace = wychodzace;
    }

    public List<Przesylka> getPrzychodzace() {
        return przychodzace;
    }

    public void setPrzychodzace(List<Przesylka> przychodzace) {
        this.przychodzace = przychodzace;
    }
}

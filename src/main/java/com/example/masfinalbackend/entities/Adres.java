package com.example.masfinalbackend.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.sql.Update;

import javax.persistence.*;
import java.util.List;

@Entity(name="adres")
public class Adres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    private String ulica;

    private String numerMieszkania;

    private String kodPocztowy;

    private String miasto;

    @ManyToOne
    @JoinColumn(name = "id")
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

package com.example.masfinalbackend.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name="Przesylka")
//https://thorben-janssen.com/complete-guide-inheritance-strategies-jpa-hibernate/#Joined
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Przesylka {

    boolean priorytetowa;
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

    private Kurier kurier;


    private String nadawca;
    private String odbiorca;

    private double waga;

    private Double znizka;


    public Przesylka() {

    }

    public Przesylka(String nadawca, String odbiorca, boolean priorytetowa) {
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.priorytetowa = priorytetowa;
    }

    @ManyToOne
    public Kurier getKurier() {
        return kurier;

    }

    public void setKurier(Kurier kurier) {
        this.kurier = kurier;
    }



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

    @Basic(optional = true)
    public Double getZnizka() {
        return znizka;
    }

    public void setZnizka(Double znizka) {
        this.znizka = znizka;
    }



    @Override
    public String toString() {


        return "Paczka{" +
                "nadawca=" + getNadawca() +
                ", odbiorca=" + getOdbiorca() +
                ", cena=" + getCena() +
                ", Kurier={" + ((kurier != null)?"imie=" + kurier.getImie() + " nazwisko=" + kurier.getNazwisko():"") + "}" +
                '}';
    }

}
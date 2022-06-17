package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.DeliveryStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="dostawa")
public class Dostawa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dostawa_id;

    public void setDostawa_id(Long id) {
        this.dostawa_id = id;
    }
    public Long getDostawa_id() {
        return dostawa_id;
    }

    public Dostawa(){

    }

    private Date dataModyfikacji;

    private Date dataRejestracji;

    private Date dataDostawy;

    private DeliveryStatus status;

    @ManyToOne
    @JoinColumn(name = "pracownik_id", updatable = false, insertable = false, nullable = false)
    private Kurier kurier;

    @ManyToOne
    @JoinColumn(name = "pracownik_id", updatable = false, insertable = false, nullable = false)
    private Pracownik pracownik;

    @ManyToOne
    @JoinColumn(name = "pojazd_id")
    private Pojazd pojazd;

    @OneToMany(mappedBy = "dostawa")
    private List<Przesylka> przesylki;

    public Date getDataModyfikacji() {
        return dataModyfikacji;
    }

    public void setDataModyfikacji(Date dataModyfikacji) {
        this.dataModyfikacji = dataModyfikacji;
    }

    public Date getDataRejestracji() {
        return dataRejestracji;
    }

    public void setDataRejestracji(Date dataRejestracji) {
        this.dataRejestracji = dataRejestracji;
    }

    public Date getDataDostawy() {
        return dataDostawy;
    }

    public void setDataDostawy(Date dataDostawy) {
        this.dataDostawy = dataDostawy;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public Kurier getKurier() {
        return kurier;
    }

    public void setKurier(Kurier kurier) {
        this.kurier = kurier;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Pojazd getPojazd() {
        return pojazd;
    }

    public void setPojazd(Pojazd pojazd) {
        this.pojazd = pojazd;
    }

    public List<Przesylka> getPrzesylki() {
        return przesylki;
    }

    public void setPrzesylki(List<Przesylka> przesylki) {
        this.przesylki = przesylki;
    }
}

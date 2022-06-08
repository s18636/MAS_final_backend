package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.DeliveryStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="Dostawa")
public class Dostawa {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public Dostawa(){

    }

    private Date dataModyfikacji;

    private Date dataRejestracji;

    private Date dataDostawy;

    private DeliveryStatus status;

    @ManyToOne
    private Kurier kurier;

    @ManyToOne
    private Pojazd pojazd;

    @OneToMany
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
}

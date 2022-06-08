package com.example.masfinalbackend.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity(name="Pracownik")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pracownik {

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

    public Pracownik(){

    }

    public Pracownik(String imie, String nazwisko, String idSeries){
        firstName = imie;
        lastName = nazwisko;
        this.idSeries = idSeries;
    }

    private String firstName;

    private String lastName;

    private boolean active;

    private String idSeries; //unique

    @OneToMany
    private List<Zatrudnienie> zatrudnienie;

    @OneToMany
    private List<Adres> adres;

    @OneToMany
    private List<Dostawa> utworzoneDostawy;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getIdSeries() {
        return idSeries;
    }

    public void setIdSeries(String idSeries) {
        this.idSeries = idSeries;
    }

    public void zatrudnij(){
        //check if pracownik is working
    }
}

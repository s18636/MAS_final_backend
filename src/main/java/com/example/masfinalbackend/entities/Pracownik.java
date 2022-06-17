package com.example.masfinalbackend.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name="pracownik")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pracownik {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pracownikId;

    public long getPracownikId() {
        return pracownikId;
    }

    private void setPracownikId(long id) {
        this.pracownikId = id;
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

    @OneToMany(mappedBy = "pracownik")
    private List<Zatrudnienie> zatrudnienie;

    @OneToMany(mappedBy = "pracownik")
    private List<Adres> adres;

    @OneToMany(mappedBy = "pracownik")
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

    public List<Zatrudnienie> getZatrudnienie() {
        return zatrudnienie;
    }

    public void setZatrudnienie(List<Zatrudnienie> zatrudnienie) {
        this.zatrudnienie = zatrudnienie;
    }

    public List<Adres> getAdres() {
        return adres;
    }

    public void setAdres(List<Adres> adres) {
        this.adres = adres;
    }

    public List<Dostawa> getUtworzoneDostawy() {
        return utworzoneDostawy;
    }

    public void setUtworzoneDostawy(List<Dostawa> utworzoneDostawy) {
        this.utworzoneDostawy = utworzoneDostawy;
    }

    public void zatrudnij(){
        //check if pracownik is working
    }
}

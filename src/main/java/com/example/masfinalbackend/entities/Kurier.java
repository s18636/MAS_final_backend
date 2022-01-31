package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.entities.Przesylka;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Kurier")
public class Kurier {
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

    private String imie;
    private String nazwisko;
    private LocalDate dataZatrudnienia;
    private LocalDate dataZwolnienia;
    private Set<String> katPrawoJazdy = new HashSet<>();

    private List<Przesylka> przesylki = new ArrayList<>();

    public Kurier() {
    }

    public Kurier(String imie, String nazwisko, LocalDate dataZatrudnienia, Set<String> katPrawoJazdy) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataZatrudnienia = dataZatrudnienia;
        this.katPrawoJazdy = katPrawoJazdy;
    }

    @OneToMany(mappedBy = "kurier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Przesylka> getPrzesylki() {
        return przesylki;
    }

    private void setPrzesylki(List<Przesylka> paczki) {
        this.przesylki = paczki;
    }

    public void addPaczka(Przesylka przesylka){
        getPrzesylki().add(przesylka);
        przesylka.setKurier(this);
    }

    public void removePaczka(Przesylka przesylka){
        getPrzesylki().remove(przesylka);
    }

    @Basic
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(LocalDate dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    @Basic(optional = true)
    public LocalDate getDataZwolnienia() {
        return dataZwolnienia;
    }

    public void setDataZwolnienia(LocalDate dataZwolnienia) {
        this.dataZwolnienia = dataZwolnienia;
    }

    @ElementCollection
    public Set<String> getKatPrawoJazdy() {
        return katPrawoJazdy;
    }

    public void setKatPrawoJazdy(Set<String> katPrawoJazdy) {
        this.katPrawoJazdy = katPrawoJazdy;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Kurier{");
        sb.append("id=").append(id);
        sb.append(", imie='").append(imie).append('\'');
        sb.append(", nazwisko='").append(nazwisko).append('\'');
        sb.append(", dataZatrudnienia= ").append(dataZatrudnienia);
        sb.append(getPrzesylki().size() == 0 ? "---" : "\n");
        for (Przesylka przesylka : getPrzesylki()) {
            sb.append(przesylka.toString());
            sb.append("\n");
        }
        sb.append("kategorie prawa jazdy: ");
        for (String kat : getKatPrawoJazdy()) {
            sb.append(kat);
            sb.append(", ");
        }
        sb.append('}');

        return sb.toString();
    }
}

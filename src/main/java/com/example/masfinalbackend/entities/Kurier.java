package com.example.masfinalbackend.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "kurier")
public class Kurier extends Pracownik {

    public Kurier() {
    }

    public Kurier(String imie, String nazwisko, String idSeries) {
        super(imie, nazwisko, idSeries);
    }

    @ManyToMany
    private List<KategoriaPrawaJazdy> kategoriaPrawaJazdy;

    @OneToMany
    @JoinColumn(name = "dostawa_id")
    private List<Dostawa> dostawy;

    public List<KategoriaPrawaJazdy> getKategoriaPrawaJazdy() {
        return kategoriaPrawaJazdy;
    }

    public void setKategoriaPrawaJazdy(List<KategoriaPrawaJazdy> kategoriaPrawaJazdy) {
        this.kategoriaPrawaJazdy = kategoriaPrawaJazdy;
    }

    public List<Dostawa> getDostawy() {
        return dostawy;
    }

    public void setDostawy(List<Dostawa> dostawy) {
        this.dostawy = dostawy;
    }

    @Override
    public String toString() {
        return null;
    }
}

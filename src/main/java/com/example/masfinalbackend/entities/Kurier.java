package com.example.masfinalbackend.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "Kurier")
public class Kurier extends Pracownik {

    public Kurier() {
    }

    public Kurier(String imie, String nazwisko, String idSeries) {
        super(imie, nazwisko, idSeries);
    }

    @ManyToMany
    private List<KategoriaPrawaJazdy> kategoriaPrawaJazdy;

    @OneToMany
    private List<Dostawa> dostawy;


    @Override
    public String toString() {
        return null;
    }
}

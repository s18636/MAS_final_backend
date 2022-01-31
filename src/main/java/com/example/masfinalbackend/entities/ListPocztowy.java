package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.entities.Przesylka;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity(name = "List")
public class ListPocztowy extends Przesylka {

    private long id;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    private double waga;
    private char format;

    public ListPocztowy() {
    }

    public ListPocztowy(String nadawca, String odbiorca, boolean priorytetowa, double waga, char format) {
        super(nadawca, odbiorca, priorytetowa);
        this.waga = waga;
        this.format = format;
    }


    @Transient
    public double getCena() {
        double cenaCal = 0;

        if(waga < 500) {
            if (format == 'S')
                cenaCal = 5;
            if (format == 'M')
                cenaCal = 7;
            if (format == 'L')
                cenaCal = 15;

        }else if (waga >= 500 && waga < 1000) {
            if (format == 'M')
                cenaCal = 7;
            if (format == 'L')
                cenaCal = 15;
        }
        else if (waga >= 1000 && waga < 2000)
            cenaCal = 15;

        if(priorytetowa)
            cenaCal += 1;

        return cenaCal;
    }

    @Basic
    public double getWaga() {
        return waga;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    @Basic
    public char getFormat() {
        return format;
    }

    public void setFormat(char format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "List{" +
                "waga=" + waga +
                ", format=" + format +
                ", nadawca='" + getNadawca() + '\'' +
                ", odbiorca='" + getOdbiorca() + '\'' +
                ", cena=" + getCena() +
                ", priorytetowa=" + priorytetowa +
                '}';
    }
}


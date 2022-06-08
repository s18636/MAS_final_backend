package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.Size;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity(name = "list")
public class ListPocztowy extends Przesylka {

    private static final double MAX_WAGA = 50;

    private double waga;
    private Size format;

    public ListPocztowy() {
    }

    public ListPocztowy(String nadawca, String odbiorca, double waga, Size format) {
        super(nadawca, odbiorca);
        this.waga = waga;
        this.format = format;
    }


    @Transient
    public double getCena() {
        double cenaCal = 0;

        if(waga < 500) {
            if (format == Size.S)
                cenaCal = 5;
            if (format == Size.M)
                cenaCal = 7;
            if (format == Size.L)
                cenaCal = 15;

        }else if (waga >= 500 && waga < 1000) {
            if (format == Size.M)
                cenaCal = 7;
            if (format == Size.L)
                cenaCal = 15;
        }
        else if (waga >= 1000 && waga < 2000)
            cenaCal = 15;

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
    public Size getFormat() {
        return format;
    }

    public void setFormat(Size format) {
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
                '}';
    }
}


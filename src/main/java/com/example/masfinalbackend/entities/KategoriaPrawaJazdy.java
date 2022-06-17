package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.DrivingLicenseCategory;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="kategoriaPrawaJazdy")
public class KategoriaPrawaJazdy {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long katId;

    public void setKatId(Long id) {
        this.katId = id;
    }
    public Long getKatId() {
        return katId;
    }

    private DrivingLicenseCategory kategoria;

    private Date dataWaznosciKategori;

    @ManyToMany
    private List<Kurier> kurier;

    public DrivingLicenseCategory getKategoria() {
        return kategoria;
    }

    public void setKategoria(DrivingLicenseCategory kategoria) {
        this.kategoria = kategoria;
    }

    public Date getDataWaznosciKategori() {
        return dataWaznosciKategori;
    }

    public void setDataWaznosciKategori(Date dataWaznosciKategori) {
        this.dataWaznosciKategori = dataWaznosciKategori;
    }

    public List<Kurier> getKurier() {
        return kurier;
    }

    public void setKurier(List<Kurier> kurier) {
        this.kurier = kurier;
    }
}

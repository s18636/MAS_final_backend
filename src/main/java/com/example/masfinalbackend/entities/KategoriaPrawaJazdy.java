package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.DrivingLicenseCategory;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="KategoriaPrawaJazdy")
public class KategoriaPrawaJazdy {

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
}

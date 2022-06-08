package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.AgreementType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "zatrudnienie")
public class Zatrudnienie {

    public Zatrudnienie() {

    }

    public Zatrudnienie(Date dataRozpoczecia, AgreementType rodzajUmowy, Pracownik pracownik) {
        this.dataRozpoczecia = dataRozpoczecia;
        this.dataZakonczenia = null;
        this.rodzajUmowy = rodzajUmowy;
        this.pracownik = pracownik;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private Date dataRozpoczecia;

    private Date dataZakonczenia;

    private AgreementType rodzajUmowy;

    @ManyToOne
    @JoinColumn(name = "id")
    private Pracownik pracownik;

    public Date getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczecia(Date dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    @Basic(optional = true)
    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(Date dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public AgreementType getRodzajUmowy() {
        return rodzajUmowy;
    }

    public void setRodzajUmowy(AgreementType rodzajUmowy) {
        this.rodzajUmowy = rodzajUmowy;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }
}

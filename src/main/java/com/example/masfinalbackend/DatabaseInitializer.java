package com.example.masfinalbackend;

import com.example.masfinalbackend.entities.*;
import com.example.masfinalbackend.enums.AgreementType;
import com.example.masfinalbackend.enums.VechicleType;
import com.example.masfinalbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    AdresRepo adresRepo;
    DostawaRepo dostawaRepo;
    KatPrawaJazdyRepo katPrawaJazdyRepo;
    PojazdRepo pojazdRepo;
    PracownikRepo pracownikRepo;
    PrzesylkaRepo przesylkaRepo;
    ZatrudnienieRepo zatrudnienieRepo;

    @Autowired
    public DatabaseInitializer(AdresRepo adresRepo, DostawaRepo dostawaRepo, KatPrawaJazdyRepo katPrawaJazdyRepo, PojazdRepo pojazdRepo, PracownikRepo pracownikRepo, PrzesylkaRepo przesylkaRepo, ZatrudnienieRepo zatrudnienieRepo) {
        this.adresRepo = adresRepo;
        this.dostawaRepo = dostawaRepo;
        this.katPrawaJazdyRepo = katPrawaJazdyRepo;
        this.pojazdRepo = pojazdRepo;
        this.pracownikRepo = pracownikRepo;
        this.przesylkaRepo = przesylkaRepo;
        this.zatrudnienieRepo = zatrudnienieRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initDb();
    }

    private void initDb(){
        Pracownik kurier1 = new Kurier("Jakub", "Szczepanski", "JKA 7712");
        Pracownik kurier2 = new Kurier("Pat", "listonosz", "LST 1234");
        Pracownik kurier3 = new Kurier("Karol", "Lipa", "KLP 8374");

        Pracownik placowkarz1 = new PracownikPlacowki("Zofia", "Kolano", "KLN 8181", "Okienko");
        Pracownik placowkarz2 = new PracownikPlacowki("Zofia", "Kolano", "KLN 8181", "Okienko");
        Pracownik placowkarz3 = new PracownikPlacowki("Iga", "Jutra", "KLN 8181", "szef okienek");

        //asocjacje pełne
        Zatrudnienie zatrudnienie1 = new Zatrudnienie(Date.valueOf("02-01-2021"), AgreementType.ZLECEIE, kurier1);
        Zatrudnienie zatrudnienie2 = new Zatrudnienie(Date.valueOf("07-01-2021"), AgreementType.O_PRACE_CZAS_NIEOKRESLONY, kurier1);
        Zatrudnienie zatrudnienie3 = new Zatrudnienie(Date.valueOf("04-01-2021"), AgreementType.B2B, kurier1);
        Zatrudnienie zatrudnienie4 = new Zatrudnienie(Date.valueOf("10-01-2021"), AgreementType.O_PRACE_CZAS_OKRESLONY, kurier1);
        Zatrudnienie zatrudnienie5 = new Zatrudnienie(Date.valueOf("16-01-2021"), AgreementType.ZLECEIE, kurier1);
        Zatrudnienie zatrudnienie6 = new Zatrudnienie(Date.valueOf("22-02-2021"), AgreementType.OKRES_PROBNY, kurier1);
        //==========

        Adres adres1 = new Adres("uliczna", "12B", "02-111", "Warszawa");
        Adres adres2 = new Adres("uliczna", "12B", "02-111", "Warszawa");
        Adres adres3 = new Adres("uliczna", "12B", "02-111", "Warszawa");
        Adres adres4 = new Adres("uliczna", "12B", "02-111", "Warszawa");
        Adres adres5 = new Adres("uliczna", "12B", "02-111", "Warszawa");
        Adres adres6 = new Adres("uliczna", "12B", "02-111", "Warszawa");
        Adres adres7 = new Adres("uliczna", "12B", "02-111", "Warszawa");
        Adres adres8 = new Adres("uliczna", "12B", "02-111", "Warszawa");
        Adres adres9 = new Adres("uliczna", "12B", "02-111", "Warszawa");
        Adres adres10 = new Adres("uliczna", "12B", "02-111", "Warszawa");

        Pojazd pojazd1 = new Pojazd("WZ 89182H", "Toyota", "Corola", VechicleType.OSOBOWY);
        Pojazd pojazd2 = new Pojazd("WZ 89182H", "Toyota", "Corola", VechicleType.OSOBOWY);
        Pojazd pojazd3 = new Pojazd("WZ 89182H", "Toyota", "Corola", VechicleType.OSOBOWY);

        Przesylka list1 = new ListPocztowy();
        Przesylka list2 = new ListPocztowy();
        Przesylka list3 = new ListPocztowy();

        Przesylka paczka1 = new Paczka();
        Przesylka paczka2 = new Paczka();
        Przesylka paczka3 = new Paczka();

        Przesylka przekazPien1 = new PrzekazPieniezny();
        Przesylka przekazPien2 = new PrzekazPieniezny();
        Przesylka przekazPien3 = new PrzekazPieniezny();

        Dostawa dostawa1 = new Dostawa();
        Dostawa dostawa2 = new Dostawa();
        Dostawa dostawa3 = new Dostawa();
    }
}

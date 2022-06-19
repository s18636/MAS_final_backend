package com.example.masfinalbackend;

import com.example.masfinalbackend.entities.*;
import com.example.masfinalbackend.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    AddressRepository addressRepository;
    DeliveryRepository deliveryRepository;
    DriverLicenseCategoryRepository driverLicenseCategoryRepository;
    VehicleRepository vehicleRepository;
    EmployeeRepository employeeRepository;
    ShipmentRepository shipmentRepository;
    EmploymentRepository employmentRepository;

    @Autowired
    public DatabaseInitializer(AddressRepository addressRepository, DeliveryRepository deliveryRepository, DriverLicenseCategoryRepository driverLicenseCategoryRepository, VehicleRepository vehicleRepository, EmployeeRepository employeeRepository, ShipmentRepository shipmentRepository, EmploymentRepository employmentRepository) {
        this.addressRepository = addressRepository;
        this.deliveryRepository = deliveryRepository;
        this.driverLicenseCategoryRepository = driverLicenseCategoryRepository;
        this.vehicleRepository = vehicleRepository;
        this.employeeRepository = employeeRepository;
        this.shipmentRepository = shipmentRepository;
        this.employmentRepository = employmentRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initDb();
    }

    private void initDb(){

        logger.info("Initalizing database");

        //TODO: fix problem with auto increment id
//        Address address1 = new Address("uliczna", "5", "02-678", "Warszawa");
//        Address address2 = new Address("pogodna", "12B", "03-545", "Warszawa");
//        Address address3 = new Address( "marszałkowska", "8", "04-191", "Warszawa");
//        Address address4 = new Address("prosta", "9", "05-111", "Warszawa");
//        Address address5 = new Address("długa", "55", "06-805", "Warszawa");
//        Address address6 = new Address("piekna", "7", "07-883", "Warszawa");
//        Address address7 = new Address("krzywa", "9/5", "08-846", "Warszawa");
//        Address address8 = new Address("hoza", "666", "09-159", "Warszawa");
//        Address address9 = new Address("wspolna", "9", "10-563", "Warszawa");
//        Address address10 = new Address("nowy swiat", "5", "11-211", "Warszawa");
//
//        addressRepository.saveAll(List.of(address1, address2, address3, address4, address5, address6, address7, address8, address9, address10));

//        KategoriaPrawaJazdy kat1 = new KategoriaPrawaJazdy(DrivingLicenseCategory.B, Date.valueOf("2030-10-11"));
//        KategoriaPrawaJazdy kat2 = new KategoriaPrawaJazdy(DrivingLicenseCategory.A, Date.valueOf("2030-10-11"));
//        KategoriaPrawaJazdy kat3 = new KategoriaPrawaJazdy(DrivingLicenseCategory.B, Date.valueOf("2030-10-11"));
//        KategoriaPrawaJazdy kat4 = new KategoriaPrawaJazdy(DrivingLicenseCategory.BE, Date.valueOf("2030-10-11"));
//        KategoriaPrawaJazdy kat5 = new KategoriaPrawaJazdy(DrivingLicenseCategory.C, Date.valueOf("2030-10-11"));
//
//        Pracownik kurier1 = new Kurier("Jakub", "Szczepanski", "JKA 7712", List.of(kat1, kat2));
//        Pracownik kurier2 = new Kurier("Pat", "listonosz", "LST 1234", List.of(kat3, kat4));
//        Pracownik kurier3 = new Kurier("Karol", "Lipa", "KLP 8374", List.of(kat5));
//
//        kurier1.setAdres(List.of(adres5));
//        kurier2.setAdres(List.of(adres6));
//        kurier3.setAdres(List.of(adres7));
//
//        Pracownik placowkarz1 = new PracownikPlacowki("Zofia", "Kolano", "KLN 8181", "Okienko");
//        Pracownik placowkarz2 = new PracownikPlacowki("Zofia", "Kolano", "KLN 8181", "Okienko");
//        Pracownik placowkarz3 = new PracownikPlacowki("Iga", "Jutra", "KLN 8181", "szef okienek");
//
//        placowkarz1.setAdres(List.of(adres8));
//        placowkarz2.setAdres(List.of(adres9));
//        placowkarz3.setAdres(List.of(adres10));
//
//        Zatrudnienie zatrudnienie1 = new Zatrudnienie(Date.valueOf("2021-02-01"), AgreementType.ZLECEIE, kurier1);
//        Zatrudnienie zatrudnienie2 = new Zatrudnienie(Date.valueOf("2021-07-01"), AgreementType.O_PRACE_CZAS_NIEOKRESLONY, kurier2);
//        Zatrudnienie zatrudnienie3 = new Zatrudnienie(Date.valueOf("2021-04-01"), AgreementType.B2B, kurier3);
//        Zatrudnienie zatrudnienie4 = new Zatrudnienie(Date.valueOf("2021-10-01"), AgreementType.O_PRACE_CZAS_OKRESLONY, placowkarz1);
//        Zatrudnienie zatrudnienie5 = new Zatrudnienie(Date.valueOf("2021-01-16"), AgreementType.ZLECEIE, placowkarz2);
//        Zatrudnienie zatrudnienie6 = new Zatrudnienie(Date.valueOf("2021-02-22"), AgreementType.OKRES_PROBNY, placowkarz3);
//
//        Pojazd pojazd1 = new Pojazd("WZ 89182H", "Toyota", "Corola", VechicleType.OSOBOWY);
//        Pojazd pojazd2 = new Pojazd("KA 47W578", "Volswagen", "Transit", VechicleType.VAN);
//        Pojazd pojazd3 = new Pojazd("WZ 9876PO", "Toyota", "Corola", VechicleType.OSOBOWY);
//
//        Przesylka list1 = new ListPocztowy("Adam Kowalski", "Justyna Kowalska",300.0 , Size.M);
//        Przesylka list2 = new ListPocztowy("Justyna Kowalska", "Adam Kowalski",500.0 , Size.L);
//        Przesylka list3 = new ListPocztowy("Ksawery Polak", "Marcin Bożek",100.0 , Size.S);
//
//        list1.setAdresNadawcy(adres1);
//        list2.setAdresNadawcy(adres2);
//        list3.setAdresNadawcy(adres3);
//
//        list1.setAdresOdbiorcy(adres2);
//        list2.setAdresOdbiorcy(adres1);
//        list3.setAdresOdbiorcy(adres4);
//
//        Przesylka paczka1 = new Paczka("Adam Kowalski", "Justyna Kowalska",4.5 , Size.M);
//        Przesylka paczka2 = new Paczka("Justyna Kowalska", "Adam Kowalski",10 , Size.L);
//        Przesylka paczka3 = new Paczka("Ksawery Polak", "Marcin Bożek",2 , Size.S);
//
//        paczka1.setAdresNadawcy(adres1);
//        paczka2.setAdresNadawcy(adres2);
//        paczka3.setAdresNadawcy(adres3);
//
//        paczka1.setAdresOdbiorcy(adres2);
//        paczka2.setAdresOdbiorcy(adres1);
//        paczka3.setAdresOdbiorcy(adres4);
//
//        Przesylka przekazPien1 = new PrzekazPieniezny("Adam Kowalski", "Justyna Kowalska",500.0 );
//        Przesylka przekazPien2 = new PrzekazPieniezny("Justyna Kowalska", "Adam Kowalski",600 );
//        Przesylka przekazPien3 = new PrzekazPieniezny("Ksawery Polak", "Marcin Bożek",2000);
//
//        przekazPien1.setAdresNadawcy(adres1);
//        przekazPien2.setAdresNadawcy(adres2);
//        przekazPien3.setAdresNadawcy(adres3);
//
//        przekazPien1.setAdresOdbiorcy(adres2);
//        przekazPien2.setAdresOdbiorcy(adres1);
//        przekazPien3.setAdresOdbiorcy(adres4);
//
//        Dostawa dostawa1 = new Dostawa(kurier1, Arrays.asList(list1, paczka1, przekazPien1));
//        Dostawa dostawa2 = new Dostawa(placowkarz1, Arrays.asList(list2, paczka2, przekazPien2));
//        Dostawa dostawa3 = new Dostawa(placowkarz2, Arrays.asList(list3, paczka3, przekazPien3));
//
//
//        katPrawaJazdyRepo.saveAll(List.of(kat1, kat2, kat3, kat4, kat5));
//        pracownikRepo.saveAll(List.of(kurier1, kurier2, kurier3, placowkarz1, placowkarz2, placowkarz3));
//        zatrudnienieRepo.saveAll(List.of(zatrudnienie1, zatrudnienie2, zatrudnienie3, zatrudnienie4, zatrudnienie5, zatrudnienie6));
//        pojazdRepo.saveAll(List.of(pojazd1, pojazd2, pojazd3));
//        przesylkaRepo.saveAll(List.of(list1, list2, list3, paczka1, paczka2, paczka3, przekazPien1, przekazPien2, przekazPien3));
//        dostawaRepo.saveAll(List.of(dostawa1, dostawa2, dostawa3));
    }
}

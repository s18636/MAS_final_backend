package com.example.masfinalbackend.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name="employee")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employee_id;

    public long getEmployee_id() {
        return employee_id;
    }

    private void setEmployee_id(long id) {
        this.employee_id = id;
    }

    public Employee(){}

    public Employee(String name, String surname, String idSeries){
        this.name = name;
        this.surname = surname;
        this.idSeries = idSeries;
    }

    private String name;

    private String surname;

    private boolean active;

    private String idSeries; //unique

    @OneToMany(mappedBy = "employee")
    private List<Employment> employment;

    @OneToMany(mappedBy = "employee")
    private List<Address> address;

    @OneToMany(mappedBy = "employee")
    private List<Delivery> createdDeliveries;

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String lastName) {
        this.surname = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getIdSeries() {
        return idSeries;
    }

    public void setIdSeries(String idSeries) {
        this.idSeries = idSeries;
    }

    public List<Employment> getEmployment() {
        return employment;
    }

    public void setEmployment(List<Employment> employment) {
        this.employment = employment;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> adres) {
        this.address = adres;
    }

    public List<Delivery> getCreatedDeliveries() {
        return createdDeliveries;
    }

    public void setCreatedDeliveries(List<Delivery> createdDeliveries) {
        this.createdDeliveries = createdDeliveries;
    }

    public void zatrudnij(){
        //check if pracownik is working
    }
}

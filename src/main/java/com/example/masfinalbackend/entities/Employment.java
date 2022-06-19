package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.AgreementType;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "employment")
public class Employment {

    public Employment() {}

    public Employment(Date startDate, AgreementType agreementType, Employee employee) {
        this.startDate = startDate;
        this.endDate = null;
        this.agreementType = agreementType;
        this.employee = employee;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employment_id;

    public void setEmployment_id(Long id) {
        this.employment_id = id;
    }

    public Long getEmployment_id() {
        return employment_id;
    }

    private Date startDate;

    private Date endDate;

    private AgreementType agreementType;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic(optional = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public AgreementType getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(AgreementType agreementType) {
        this.agreementType = agreementType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

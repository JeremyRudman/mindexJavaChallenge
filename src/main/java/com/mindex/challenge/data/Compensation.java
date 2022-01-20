package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Compensation {
    private String compensationId;
    // stores employee Id separately for easy lookup from database
    private String employeeId;
    private Employee employee;

    // It may be ideal to create another field with the currency type
    // if there is any possible future need to pay employees in other currency.

    // BigDecimal is used here to avoid precision problems with floats 
    // (E.G. 0.03 - 0.02 != 0.1 with type float but does equal 0.01 with BigDecimal)
    private BigDecimal salary;
    private LocalDate effectiveDate; 

    public Compensation() {
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public String getCompensationId() {
        return this.compensationId;
    }

    public void setCompensationId(String compensationId) {
        this.compensationId = compensationId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        if(employee != null) {
            this.employeeId = this.employee.getEmployeeId();
        }
    }

    public String getEmployeeId(){
        return this.employeeId;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

}

package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.sql.Date;

public class Compensation {
    private Employee employee;

    // It may be ideal to create another field with the currency type
    // if there is any possible future need to pay employees in other currency.

    // BigDecimal is used here to avoid precision problems with floats 
    // (E.G. 0.03 - 0.02 != 0.1 with type float but does equal 0.01 with BigDecimal)
    private BigDecimal salary;
    private Date effectiveDate; 

    public Compensation() {
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

}

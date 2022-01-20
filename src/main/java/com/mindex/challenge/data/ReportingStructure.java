package com.mindex.challenge.data;

import java.util.HashSet;
import java.util.Set;

public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;

    public ReportingStructure () {  
    }

    public Employee getEmployee() {
        return this.employee;
    }

    /**
     * sets the employee field in the class and also updates the numberOfReports field
     * 
     * @param employee the employee that will be set in the class
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;

        // When a new employee is set then the number of reports is updated
        this.numberOfReports = calculateNumberOfReports();
    }

    
    public int getNumberOfReports() {
        this.numberOfReports = calculateNumberOfReports();
        return this.numberOfReports;
    }

    /**
     * Goes through the direct reports for the employee and then goes through the reports
     * of those direct reports. The total number of unique reports in that set of reports
     * is counted and then return. If there is no employee set then 0 is returned.
     * 
     * @return the sum of direct reports for the employee and all their distinct reports,
     */
    private int calculateNumberOfReports() {
        // null check if employee is not set or was later set to null
        if(employee == null) {
            return 0;
        }

        // Since ordering is not important and we only want to store unique reports
        // HashSet was used as the set implementation as it has the highest performance
        Set<String> uniqueReportsId = new HashSet<String>();
        
        if(employee.getDirectReports() != null) {
            for (Employee reportLevelOne : employee.getDirectReports()) {
                uniqueReportsId.add(reportLevelOne.getEmployeeId());
                if(reportLevelOne.getDirectReports() != null) {
                    for (Employee reportLevelTwo : reportLevelOne.getDirectReports()) {
                        uniqueReportsId.add(reportLevelTwo.getEmployeeId());
                    }
                }
            }
        }
        return uniqueReportsId.size();
    }
}

package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.ReportingStructureService;
import com.mindex.challenge.service.EmployeeService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportStructureServiceImplTest {
    
    private String reportStructureIdUrl;

    @Autowired
    private EmployeeService employeeService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        reportStructureIdUrl = "http://localhost:" + port + "/reportStructure/{employeeId}";
    }

    @Test
    public void testRead() {
        Employee testBossEmployee = new Employee();
        Employee tempReportEmployee = new Employee();
        tempReportEmployee.setFirstName("John");
        tempReportEmployee.setFirstName("Dow");
        tempReportEmployee = employeeService.create(tempReportEmployee);

        assertNotNull(tempReportEmployee.getEmployeeId());

        testBossEmployee.setFirstName("Jane");
        testBossEmployee.setFirstName("Dow");
        ArrayList<Employee> directReport = new ArrayList<Employee>();
        directReport.add(tempReportEmployee);
        testBossEmployee.setDirectReports(directReport);
        testBossEmployee = employeeService.create(testBossEmployee);

        assertNotNull(testBossEmployee.getEmployeeId());


        // Read checks
        ReportingStructure readReportStructure = restTemplate.getForEntity(reportStructureIdUrl, ReportingStructure.class, testBossEmployee.getEmployeeId()).getBody();
        assertEquals(testBossEmployee.getEmployeeId(), readReportStructure.getEmployee().getEmployeeId());
        assertEquals(testBossEmployee.getDirectReports().size(), readReportStructure.getNumberOfReports());
    }
}


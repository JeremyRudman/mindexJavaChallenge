package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportStructureController.class);

    @Autowired
    private ReportingStructureService reportingStructureService;

    @GetMapping("/reportStructure/{employeeId}")
    public ReportingStructure read(@PathVariable String employeeId) {
        LOG.debug("Received reportStructure get request for employeeId [{}]", employeeId);

        return reportingStructureService.read(employeeId);
    }
}

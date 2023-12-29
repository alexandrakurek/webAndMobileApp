package com.aleksandrakurek.webapp.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @GetMapping
    public List<Report> getAllReports(){
        return reportService.findAllReports();
    }
    @PostMapping
    public Report createReport(@RequestParam Report report){
        return reportService.createReport(report);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable Long id, @RequestParam Report reportDetails){
        return reportService.getReportById(id)
                .map(report -> {
                    report.setReportingUser(reportDetails.getReportingUser());
                    report.setAssignedUser(reportDetails.getAssignedUser());
                    report.setContent(reportDetails.getContent());
                    report.setAddress(reportDetails.getAddress());
                    Report updateReport = reportService.updateReport(report);
                    return ResponseEntity.ok(updateReport);
                })
                .orElseGet(() ->ResponseEntity.notFound().build());
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteReport(@PathVariable Long id) {
        return reportService.getReportById(id)
                .map(report -> {
                        reportService.deleteReport(id);
                return ResponseEntity.ok().build();
    })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }



}

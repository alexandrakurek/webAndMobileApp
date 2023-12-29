package com.aleksandrakurek.webapp.report;

import org.atmosphere.config.service.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private ReportService reportService;
    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<Report> getAllReports(){
        return reportService.findAllReports();
    }
    @PostMapping("/create")
    public ModelAndView createReport(@ModelAttribute Report report){
         reportService.createReport(report);
         return new ModelAndView("redirect:/reports/send");
    }
    @GetMapping("/send")
    public ModelAndView sendReport(){
        ModelAndView modelAndView = new ModelAndView("report_sent");
        return modelAndView;
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

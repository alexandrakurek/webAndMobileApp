package com.aleksandrakurek.webapp.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;
    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public String listReports(Model model){
        model.addAttribute("reports", reportService.findAllReports());
        return "reports";
    }
    @GetMapping("/report")
    public String showReportForm(Model model){
        model.addAttribute("report", new Report());
        return "report";
    }
    @PostMapping("/reports/save")
    public String saveReport(@ModelAttribute Report report, Model model){
        reportService.createReport(report);
        model.addAttribute("message", "Zgłoszenie zostało wysłane pomyślnie.");
        return "reports";
    }
    @GetMapping("/edit/{id}")
    public String editReportForm(@PathVariable Long id, Model model){
        Report report = reportService.getReportById(id).orElseThrow(() -> new IllegalArgumentException("Invalid report Id:" + id));
        model.addAttribute("report", report);
        return "report";
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteReport(@PathVariable Long id){
        reportService.deleteReport(id);
        return "redirect:/reports";
    }


}

package com.aleksandrakurek.webapp.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/reports")
public class ReportController {
    private ReportRepository reportRepository;
    @Autowired
    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @GetMapping
    public String listReports(Model model){
        model.addAttribute("reports", reportRepository.findAll());
        return "reports";
    }
    @GetMapping("/report")
    public String showReportForm(Model model){
        model.addAttribute("report", new Report());
        return "report";
    }
    @PostMapping("/reports/save")
    public String saveReport(@ModelAttribute Report report, Model model){
        reportRepository.save(report);
        model.addAttribute("message", "Zgłoszenie zostało wysłane pomyślnie.");
        return "report";
    }
    @GetMapping("/edit/{id}")
    public String editReportForm(@PathVariable Long id, Model model){
        Report report = reportRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid report Id:" + id));
        model.addAttribute("report", report);
        return "report";
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteReport(@PathVariable Long id){
        reportRepository.deleteById(id);
        return "redirect:/reports";
    }


}

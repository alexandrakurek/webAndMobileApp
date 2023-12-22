package com.aleksandrakurek.webapp.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;
    public Report createReport(Report report){
        return reportRepository.save(report);
    }
    public Optional <Report> getReportById(Long id){
        return reportRepository.findById(id);
    }
    public List <Report> getAllReports(){
        return reportRepository.findAll();
    }
    public Report updateReport(Report report) {
        return reportRepository.save(report);
    }
    public void deleteReport(Long id){
        reportRepository.deleteById(id);
    }

}

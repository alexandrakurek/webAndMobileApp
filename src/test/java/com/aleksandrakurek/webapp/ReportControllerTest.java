package com.aleksandrakurek.webapp;

import com.aleksandrakurek.webapp.report.Report;
import com.aleksandrakurek.webapp.report.ReportController;
import com.aleksandrakurek.webapp.report.ReportService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.List;

@SpringBootTest
public class ReportControllerTest {
    @MockBean
    private ReportService reportService;
    @InjectMocks
    private ReportController reportController;
    @Test
    public void whenGetAllReports_thenReportsReturned(){
        when(reportService.getAllReports()).thenReturn(List.of(new Report()));
        List<Report> reports = reportController.getAllReports();
        assertEquals(1,reports.size());
    }

}

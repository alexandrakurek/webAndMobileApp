package com.aleksandrakurek.webapp;

import com.aleksandrakurek.webapp.report.ReportController;
import com.aleksandrakurek.webapp.report.ReportService;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
public class ReportControllerTest {
    @MockBean
    private ReportService reportService;
    @InjectMocks
    private ReportController reportController;
    /*@Test
    public void whenGetAllReports_thenReportsReturned(){
        when(reportService.getAllReports()).thenReturn(List.of(new Report()));
        List<Report> reports = reportController.getAllReports();
        assertEquals(1,reports.size());
    }

     */

}

package com.aleksandrakurek.webapp.report;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id zgłoszenia
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportDate; // data zgłoszenia
    @Column(nullable = false)
    private String reportingUser; //osoba zgłaszająca
    @Column
    private String assignedUser; //osoba przypisana
    @Column(nullable = false, length = 1000)
    private String content; //treść zgłoszenia
    @Column(nullable = false)
    private String address; //adres zgłoszenia

    public Report (){

    }
    public Report(Long id, Date reportDate, String reportingUser, String assignedUser, String content, String address) {
        this.id = id;
        this.reportDate = reportDate;
        this.reportingUser = reportingUser;
        this.assignedUser = assignedUser;
        this.content = content;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public String getReportingUser() {
        return reportingUser;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public String getContent() {
        return content;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public void setReportingUser(String reportingUser) {
        this.reportingUser = reportingUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

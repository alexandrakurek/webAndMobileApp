package com.aleksandrakurek.webapp.report;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}


package com.example.demo.Entities;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "reservation")
@Data
public class Reservation {
    @Id
    @Column(name = "id_reservation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client",referencedColumnName = "id_client")
    private Client client;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_employee",referencedColumnName = "id_employee")
    private Employee employee;

    @Column(name = "time_reservation")
    private Timestamp timeReservation;

    @Column(name = "overall_price")
    private Integer overallPrice;
}

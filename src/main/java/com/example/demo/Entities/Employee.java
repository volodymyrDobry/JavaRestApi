package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer id;

    @Column(name = "name_employee")
    private String name;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "salary")
    private Integer salary;
}

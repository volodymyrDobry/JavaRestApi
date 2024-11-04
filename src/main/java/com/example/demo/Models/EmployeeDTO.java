package com.example.demo.Models;

import lombok.Data;

import java.sql.Date;

@Data
public class EmployeeDTO {
    private Integer id;
    private String name;
    private Date birthday;
    private Integer salary;
}

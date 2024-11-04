package com.example.demo.Entities;

import com.example.demo.EnumeratedTypes.MealType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

@Data
@Entity
@Table(name = "dish")
public class Dish{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dish")
    private Integer id;

    @Column(name = "name_dish")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Enumerated(EnumType.STRING)
    @Column(name = "meal_type",columnDefinition = "meal_type")
    @JdbcType(value = PostgreSQLEnumJdbcType.class)
    private MealType mealType;
}

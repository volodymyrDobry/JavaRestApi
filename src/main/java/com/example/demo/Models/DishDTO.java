package com.example.demo.Models;
import com.example.demo.EnumeratedTypes.MealType;
import lombok.Data;

@Data
public class DishDTO {
    private Integer id;
    private String name;
    private Integer price;
    private MealType mealType;


}

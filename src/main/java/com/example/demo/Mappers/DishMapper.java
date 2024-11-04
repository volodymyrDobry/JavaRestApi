package com.example.demo.Mappers;

import ch.qos.logback.core.model.ComponentModel;
import com.example.demo.Entities.Dish;
import com.example.demo.Models.DishDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DishMapper  {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "mealType", target = "mealType")
    Dish fromDTOToDish(DishDTO dto, @MappingTarget Dish dish);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "mealType", target = "mealType")
    Dish fromDTOToDish(DishDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "mealType", target = "mealType")
    DishDTO fromDishToDTO(Dish dish, @MappingTarget DishDTO dishDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "mealType", target = "mealType")
    DishDTO fromDishToDTO(Dish dish);


    // Custom method to retain old value if new value is zero
    default Integer retainOldValueIfZero(Integer newValue, Integer oldValue) {
        return (newValue != null) ? newValue : oldValue;
    }

    @AfterMapping
    default void afterMapping(@MappingTarget Dish dish, DishDTO dto) {
        dish.setPrice(retainOldValueIfZero(dto.getPrice(), dish.getPrice()));
        // Add any other fields you want to check for zero value handling here
    }
}

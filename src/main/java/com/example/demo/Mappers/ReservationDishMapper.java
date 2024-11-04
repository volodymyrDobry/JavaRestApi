package com.example.demo.Mappers;

import com.example.demo.Entities.ReservationDish;
import com.example.demo.Models.ReservationDishDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface ReservationDishMapper {
    @Mapping(source = "id.idDish",target = "idDish")
    @Mapping(source = "id.idReservation",target = "idReservation")
    ReservationDishDTO toDto(ReservationDish reservationDish);

    @Mapping(source = "idDish",target = "id.idDish")
    @Mapping(source = "idReservation",target = "id.idReservation")
    ReservationDish fromDto(ReservationDishDTO reservationDishDTO);
}

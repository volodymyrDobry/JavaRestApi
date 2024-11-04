package com.example.demo.Mappers;

import com.example.demo.Entities.Employee;
import com.example.demo.Entities.Reservation;
import com.example.demo.Entities.ReservationDish;
import com.example.demo.Models.EmployeeDTO;
import com.example.demo.Models.ReservationDTO;
import com.example.demo.Models.ReservationDishDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    @Mapping(source = "client.id",target = "idClient")
    @Mapping(source = "employee.id",target = "idEmployee")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ReservationDTO toDto(Reservation reservation);

    @Mapping(target = "client.id",source = "idClient")
    @Mapping(target = "employee.id",source = "idEmployee")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reservation toEntity(ReservationDTO reservationDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toEntity(ReservationDTO reservationDTO, @MappingTarget Reservation reservation);

    default Integer retainOldValueIfZero(Integer newValue, Integer oldValue) {
        return (newValue != null) ? newValue : oldValue;
    }

    @AfterMapping
    default void afterMapping(@MappingTarget Reservation reservation, ReservationDTO dto) {
        reservation.setOverallPrice(retainOldValueIfZero(dto.getOverallPrice(), reservation.getOverallPrice()));
    }

}

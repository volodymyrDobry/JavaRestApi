package com.example.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Embeddable
@Data
public class DishReservationKey implements Serializable {
    @Column(name = "id_reservation")
    private int idReservation;
    @Column(name = "id_dish")
    private int idDish;
}

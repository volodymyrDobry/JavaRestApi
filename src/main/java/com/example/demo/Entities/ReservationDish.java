package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dish_reservation")
@Data
public class ReservationDish {
    @EmbeddedId
    private DishReservationKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idDish")
    private Dish dish;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idReservation")
    private Reservation reservation;

    @Column(name = "quantity")
    private int quantity;
}

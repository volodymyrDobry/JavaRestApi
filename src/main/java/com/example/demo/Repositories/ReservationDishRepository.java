package com.example.demo.Repositories;

import com.example.demo.Entities.ReservationDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDishRepository extends JpaRepository<ReservationDish, Integer> {

}

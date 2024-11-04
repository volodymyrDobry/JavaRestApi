package com.example.demo.Controllers;

import com.example.demo.Entities.Reservation;
import com.example.demo.Models.ReservationDTO;
import com.example.demo.Services.ReservationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Reservations",produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {
    private final ReservationService reservationService;
    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/All")
    public List<ReservationDTO> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable("id") int id) {
        try {
            ReservationDTO reservationDTO = reservationService.getReservation(id);
            return ResponseEntity.ok(reservationDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        ReservationDTO createdReservation = reservationService.createReservation(reservationDTO);
        return ResponseEntity.ok(createdReservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable  int id,@RequestBody ReservationDTO reservationDTO) {
        ReservationDTO newReservation = reservationService.updateReservation(id, reservationDTO);
        return ResponseEntity.ok(newReservation);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReservationDTO> patchMapping(@PathVariable  int id, @RequestBody ReservationDTO reservationDTO) {
        ReservationDTO newReservation = reservationService.patchReservation(id, reservationDTO);
        return ResponseEntity.ok(newReservation);
    }


}

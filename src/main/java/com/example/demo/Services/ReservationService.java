package com.example.demo.Services;

import com.example.demo.Entities.Reservation;
import com.example.demo.Mappers.ReservationMapper;
import com.example.demo.Models.ReservationDTO;
import com.example.demo.Repositories.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ReservationService {
    private ReservationRepository reservationRepository;
    private ReservationMapper reservationMapper;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    private Reservation getReservationById(int id) {
        return reservationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream().map(reservationMapper::toDto).toList();
    }

    public ReservationDTO getReservation(int id) {
        return reservationMapper.toDto(getReservationById(id));
    }

    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        return reservationMapper.toDto(reservationRepository.save(reservation));
    }

    public ReservationDTO updateReservation(int id, ReservationDTO reservationDTO) {
        Reservation reservation = getReservationById(id);
        reservationMapper.toEntity(reservationDTO, reservation);
        reservationRepository.save(reservation);
        return reservationMapper.toDto(reservation);
    }

    public ReservationDTO deleteReservation(int id) {
        Reservation reservation = getReservationById(id);
        reservationRepository.delete(reservation);
        return reservationMapper.toDto(reservation);
    }

    public ReservationDTO putReservation(int id, ReservationDTO reservationDTO) {
        Reservation reservation = getReservationById(id);
        reservationMapper.toEntity(reservationDTO);
        reservationRepository.save(reservation);
        return reservationMapper.toDto(reservation);
    }

    public ReservationDTO patchReservation(int id, ReservationDTO reservationDTO) {
        Reservation reservation = getReservationById(id);
        reservationMapper.toEntity(reservationDTO,reservation);
        reservationRepository.save(reservation);
        return reservationMapper.toDto(reservation);
    }

}

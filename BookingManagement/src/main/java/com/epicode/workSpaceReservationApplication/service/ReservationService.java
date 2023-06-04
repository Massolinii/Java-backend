package com.epicode.workSpaceReservationApplication.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.workSpaceReservationApplication.model.Reservation;
import com.epicode.workSpaceReservationApplication.model.User;
import com.epicode.workSpaceReservationApplication.repository.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
    private ReservationRepository reservationRepository;
	
	@Autowired
    @Qualifier("ReservationNoParamsBean")
    ObjectProvider<Reservation> reservationNoParamsProvider;

    @Autowired
    @Qualifier("ReservationWithParamsBean")
    ObjectProvider<Reservation> reservationWithParamsProvider;

    @Autowired
    @Qualifier("ReservationFakeBean")
    ObjectProvider<Reservation> reservationFakeProvider;

    public Reservation createReservationNoParamsReservation() {
        return reservationNoParamsProvider.getObject();
    }

    public Reservation createReservationWithParamsReservation(
            User user, LocalDate date, LocalTime startTime,
            LocalTime endTime) {
        return reservationWithParamsProvider.getObject(
                user, date, startTime, endTime);
    }

    public Reservation createReservationFake() {
        return reservationFakeProvider.getObject();
    }

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void update(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    public Reservation getById(Long id) {
        return reservationRepository.findById(id).get();
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getByUserAndDate(User user, LocalDate date) {
        return reservationRepository.findByUserAndData(user, date);
    }

}

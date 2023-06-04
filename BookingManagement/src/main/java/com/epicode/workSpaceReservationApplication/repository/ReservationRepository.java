package com.epicode.workSpaceReservationApplication.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.workSpaceReservationApplication.model.Reservation;
import com.epicode.workSpaceReservationApplication.model.User;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	 List<Reservation> findByUserAndData(User user, LocalDate data);
	 List<Reservation> findByUser(User user);

}

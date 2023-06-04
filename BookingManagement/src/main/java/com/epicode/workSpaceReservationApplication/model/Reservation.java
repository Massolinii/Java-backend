package com.epicode.workSpaceReservationApplication.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "reservations")
@Access(AccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Reservation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@NonNull private LocalDate data;
	@NonNull private LocalTime startTime;
	@NonNull private LocalTime endTime;
    
    @ManyToOne
    @JoinColumn(name = "space_id")
    private Space space;
    
    @ManyToOne
    @JoinColumn(name = "user_username")
    private User user;
    
    public Reservation(
            LocalDate data, LocalTime startTime, LocalTime endTime) {
        this.data = data;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}

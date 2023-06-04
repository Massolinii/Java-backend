package com.epicode.workSpaceReservationApplication.configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.workSpaceReservationApplication.model.Reservation;
import com.github.javafaker.Faker;

@Configuration
public class ReservationConfiguration {
	
    @Bean("ReservationWithParamsBean")
    @Scope("prototype")
    Reservation reservationWithParams(
            LocalDate date, LocalTime startTime, LocalTime endTime) {
        return new Reservation();
    }
    @Bean("ReservationNoParamsBean")
    @Scope("prototype")
    Reservation reservationNoParams() {
        return new Reservation();
    }
    @Bean("ReservationFakeBean")
    @Scope("prototype")
    Reservation reservationFake() {
        Faker faker = new Faker(new Locale("it", "it"));
        LocalDate date = LocalDate.now().plusMonths(faker.number().numberBetween(0, 12));
        LocalTime startTime = LocalTime.of(faker.number().numberBetween(8, 18), 0);
        LocalTime endTime = startTime.plusHours(faker.number().numberBetween(1, 10))
                .withMinute(0);
        endTime = endTime.isAfter(LocalTime.of(18, 0)) ? LocalTime.of(18, 0) : endTime;
        return new Reservation(date, startTime, endTime);
    }

}

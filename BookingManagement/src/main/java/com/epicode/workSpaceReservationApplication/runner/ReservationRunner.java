package com.epicode.workSpaceReservationApplication.runner;

import java.util.Random;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.workSpaceReservationApplication.model.Reservation;
import com.epicode.workSpaceReservationApplication.model.User;
import com.epicode.workSpaceReservationApplication.model.Space;
import com.epicode.workSpaceReservationApplication.service.ReservationService;
import com.epicode.workSpaceReservationApplication.service.SpaceService;
import com.epicode.workSpaceReservationApplication.service.UserService;


@Component
@Order(4)
public class ReservationRunner implements CommandLineRunner {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @Autowired
    private SpaceService spaceService;

    @Value("${reservations_quantity}")
    private int quantity;

    public void run(String... args) throws Exception {
        List<User> users = userService.getAllWithNoRes();
        if(users.isEmpty()) {
            return;
        }
        for (int i = 0; i < quantity; i++) {
            User user = users.get(new Random().nextInt(users.size()));
            this.saveReservationFake(user);
        }
    }

    private void saveReservationFake(User user) {
        Reservation reservation;
        Space space;
        List<Space> spaces = this.spaceService.getAll();
        do {
            reservation = this.reservationService.createReservationFake();
            space = spaces.get(new Random().nextInt(spaces.size()));
            reservation.setUser(user);
        } while (!this.spaceService.checkSpaceIsAvailable(
                space, reservation));
        reservation.setSpace(space);
        this.reservationService.save(reservation);
    }
}


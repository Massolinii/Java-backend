package com.epicode.workSpaceReservationApplication.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.workSpaceReservationApplication.model.Building;
import com.epicode.workSpaceReservationApplication.service.BuildingService;

@Component
@Order(2)
public class BuildingRunner implements CommandLineRunner {
	
    @Autowired
    private BuildingService buildingService;

    @Value("${buildings_quantity}")
    private int quantity;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < this.quantity; i++) {
            this.saveBuildingFake();
        }
    }

    private void saveBuildingFake() {
        Building building = this.buildingService.createBuildingFake();
        this.buildingService.save(building);
    }

}
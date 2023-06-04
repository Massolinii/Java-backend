package com.epicode.workSpaceReservationApplication.runner;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.workSpaceReservationApplication.model.Building;
import com.epicode.workSpaceReservationApplication.model.Space;
import com.epicode.workSpaceReservationApplication.service.BuildingService;
import com.epicode.workSpaceReservationApplication.service.SpaceService;

@Component
@Order(3)
public class SpaceRunner implements CommandLineRunner {
	
    @Autowired
    private SpaceService workspaceService;

    @Autowired
    private BuildingService buildingService;

    @Value("${workspaces_quantity}")
    private int quantity;

    @Override
    public void run(String... args) throws Exception {
        List<Building> buildings = this.buildingService.findAll();
        for (int i = 0; i < this.quantity; i++) {
            Building building = buildings.get(
                    new Random().nextInt(buildings.size()));
            this.saveSpaceFake(building);
        }
    }

    private void saveSpaceFake(Building building) {
        Space workspace;
        do {
            workspace = this.workspaceService.createWorkspaceFake();
            workspace.setBuilding(building);
        } while (this.workspaceService.getByNameAndBuilding(
                workspace.getName(), building) != null);
        this.workspaceService.save(workspace);
    }

}
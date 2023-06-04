package com.epicode.workSpaceReservationApplication.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.workSpaceReservationApplication.model.Building;
import com.epicode.workSpaceReservationApplication.repository.BuildingRepository;

@Service
public class BuildingService {
	
	@Autowired
	BuildingRepository buildingRepository;
	
	@Autowired
    @Qualifier("BuildingNoParamsBean")
    ObjectProvider<com.epicode.workSpaceReservationApplication.model.Building> buildingNoParamsProvider;

    @Autowired
    @Qualifier("BuildingWithParamsBean")
    ObjectProvider<Building> buildingWithParamsProvider;

    @Autowired
    @Qualifier("BuildingFakeBean")
    ObjectProvider<Building> buildingFakeProvider;

    public Building newBuildingNoParamsBuilding() {
        return buildingNoParamsProvider.getObject();
    }
    public Building createBuildingWithParamsBuilding(
            String name, String address, String city) {
        return buildingWithParamsProvider.getObject();
    }
    public Building createBuildingFake() {
        return buildingFakeProvider.getObject();
    }
    public void save(Building building) {
        buildingRepository.save(building);
    }

    public void update(Building building) {
        buildingRepository.save(building);
    }

    public void delete(Building building) {
        buildingRepository.delete(building);
    }

    public List<Building> findByName(String name) {
        return buildingRepository.findByName(name);
    }

    public List<Building> findAll() {
        return buildingRepository.findAll();
    }
    
    public Building getById(Long id) {
        return buildingRepository.findById(id).get();
    }
}

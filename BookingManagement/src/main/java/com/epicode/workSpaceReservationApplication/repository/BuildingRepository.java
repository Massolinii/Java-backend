package com.epicode.workSpaceReservationApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.workSpaceReservationApplication.model.Building;
import com.epicode.workSpaceReservationApplication.model.City;

public interface BuildingRepository extends JpaRepository<Building, Long> {
	
	List<Building> findByCity(City city);
	
	List<Building> findByName(String nome);
	
	

}

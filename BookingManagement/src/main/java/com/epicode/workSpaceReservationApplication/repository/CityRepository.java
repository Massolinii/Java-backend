package com.epicode.workSpaceReservationApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.workSpaceReservationApplication.model.City;
import com.epicode.workSpaceReservationApplication.model.Space;

public interface CityRepository extends JpaRepository<City, Long>{

	public List<Space> findByName(String name);
}

package com.epicode.workSpaceReservationApplication.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.epicode.workSpaceReservationApplication.enums.SpaceTypology;
import com.epicode.workSpaceReservationApplication.model.Building;
import com.epicode.workSpaceReservationApplication.model.City;
import com.epicode.workSpaceReservationApplication.model.Space;

public interface SpaceRepository extends JpaRepository<Space, Long>{
	List<Space> findByName(String name);
	
    @Query("SELECT w FROM Workspace w JOIN w.building b WHERE w.type = :type AND b.city = :city")
    List<Space> findByTypeAndCity(
                    @Param("type") SpaceTypology type,
                    @Param("city") String city);
    
	List<Space> findFreeByCity(City city, SpaceTypology type,  LocalDate date);
	
	Space findByNameAndBuilding(String name, Building building);

}

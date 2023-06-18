package com.massolini.firesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.massolini.firesystem.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{
	
}
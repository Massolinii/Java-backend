package com.massolini.firesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.massolini.firesystem.model.*;
import com.massolini.firesystem.repository.PlaceRepository;

@Controller
@RequestMapping("/places")
public class PlaceController {
	
	private final PlaceRepository placeRepository;
	
	@Autowired
	public PlaceController(PlaceRepository placeRepository) {
		this.placeRepository = placeRepository;
	}
	
	@PostMapping
	@ResponseBody
	public Place createplace(@RequestBody Place place) {
		return placeRepository.save(place);
	}
	
	@GetMapping
	@ResponseBody
	public List<Place> getPlaces() {
		return placeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Place getPlace(@PathVariable("id") Long id) {
		return placeRepository.findById(id).orElse(null);
	}
	

}

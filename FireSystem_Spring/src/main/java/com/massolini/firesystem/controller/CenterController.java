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

import com.massolini.firesystem.model.Center;
import com.massolini.firesystem.repository.CenterRepository;

@Controller
@RequestMapping("/centers")
public class CenterController {
	
	private final CenterRepository centerRepository;
	
	@Autowired
	public CenterController(CenterRepository centerRespository) {
		this.centerRepository = centerRespository;
	}
	
	@PostMapping
	@ResponseBody
	public Center createCenter(@RequestBody Center center) {
		return centerRepository.save(center);
	}
	
	@GetMapping
	@ResponseBody
	public List<Center> getAllCenters() {
		return centerRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Center getCenter(@PathVariable("id") Long id) {
		return centerRepository.findById(id).orElse(null);
	}
	
}
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

import com.massolini.firesystem.model.Alarm;
import com.massolini.firesystem.repository.AlarmRepository;

@Controller
@RequestMapping("/alarms")
public class AlarmController {

	private final AlarmRepository alarmRepository;

	@Autowired
	public AlarmController(AlarmRepository alarmRepository) {
		this.alarmRepository = alarmRepository;
	}

	@GetMapping
	@ResponseBody
	public List<Alarm> getAlarms() {
		return alarmRepository.findAll();
	}
	
	@PostMapping
	@ResponseBody
	public Alarm createAlarm(@RequestBody Alarm alarm) {
		return alarmRepository.save(alarm);
	}


	@GetMapping("/{id}")
	@ResponseBody
	public Alarm getAlarm(@PathVariable("id") Long id) {
		return alarmRepository.findById(id).orElse(null);
	}

}

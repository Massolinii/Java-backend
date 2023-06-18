package com.massolini.firesystem.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "places")
public class Place {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String phone;
	
	// JSON
//	{
//		"name": "Roma est",
//		"phone": "16845"
//	}
	
	public Place(String name, List<Alarm> alarms, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
}

package com.massolini.firesystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "sonde")
public class Alarm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Place place;
	@ManyToOne
	@JoinColumn(nullable = false, name = "control_center")
	private Center center;
	@Enumerated(EnumType.STRING)
	private SmokeLevel smoke;
	private String latitude;
	private String longitude;
	
	public Alarm(Place place, Center center, SmokeLevel smoke) {
		super();
		this.place = place;
		this.center = center;
		this.smoke = smoke;
	}



}
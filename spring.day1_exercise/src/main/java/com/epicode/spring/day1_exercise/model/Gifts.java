package com.epicode.spring.day1_exercise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Gifts {
	
	private String name;
	private double price;
	
	public String getMenuItems() {
		return this.name + " - Price: " + this.price + "€";
	}

}

package com.epicode.spring.day1_exercise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class FoodItem {
	
	protected String name;
	protected double price;
	protected double calories;
	
	public String getMenuItems() {
		return this.name + " - Cal. " + this.calories + " - Price: " + this.price + "€";
	}

}

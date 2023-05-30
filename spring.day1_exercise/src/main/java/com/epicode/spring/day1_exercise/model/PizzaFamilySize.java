package com.epicode.spring.day1_exercise.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaFamilySize extends Pizza {
	
	private Pizza pizza;
	private String name;
	private double calories;
	private double price;

	public PizzaFamilySize(Pizza pizza) {
		super();
		this.pizza = pizza;
		this.name = "Family Size for Pizza";
		this.price = 4.15;
		this.calories = 1.95;
	}
	
	public String getMenuItemLine() {
		return this.name + " - Cal: x" + this.calories + " - Price: +" + this.price + "€";
	}
	
	

}

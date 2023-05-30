package com.epicode.spring.day1_exercise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Topping extends FoodItem {

	private Pizza pizza;

	public Topping(String name, double price, double calories) {
		super(name, price, calories);
	}
	
	
}

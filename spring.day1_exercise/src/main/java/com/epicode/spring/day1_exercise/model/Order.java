package com.epicode.spring.day1_exercise.model;

import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
	
	public Table table;
	public int orderNumber;
	public List<FoodItem> elements;
	public String nota = null;
	public LocalTime time = LocalTime.now();
	public OrderStatus orderStatus;
	public int seats;
	public double coverCharge = 2.0;
	
	 public double getTotalCost() {
	        double totalCost = seats * coverCharge;

	        for (FoodItem item : elements) {
	            totalCost += item.getPrice();
	        }

//	        for (Franchise item : elements) {
//	            totalCost += item.getPrice();
//	        }

	        return totalCost;
	    }
}

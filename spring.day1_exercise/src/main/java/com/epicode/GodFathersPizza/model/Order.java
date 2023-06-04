package com.epicode.GodFathersPizza.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Order {
	
	private Table table;
	private int orderNumber;
	private List<FoodItem> orderedItem;
	private String nota;
	private LocalDateTime time;
	private OrderStatus orderStatus;
	private int seats = 1;
	@Value("${cover.charge}") private int coverCharge;
	

	public Order(Table table, int orderNumber, List<FoodItem> orderedItem, String nota, LocalDateTime time,
			OrderStatus orderStatus, int seats, int coverCharge) {
		super();
		this.table = table;
		this.orderNumber = orderNumber;
		this.orderedItem = new ArrayList<FoodItem>();
		this.nota = null;
		this.time = LocalDateTime.now();
		this.orderStatus  = OrderStatus.IN_PROGRESS;
		this.seats = 1;
		this.coverCharge = coverCharge;
	}
}

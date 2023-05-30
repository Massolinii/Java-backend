package com.epicode.spring.day1_exercise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Table {
	
	private int tableNumber;
	private int maxSeats;
	private TableStatus tableStatus;

}

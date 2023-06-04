package com.epicode.GodFathersPizza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Table {
	
	private int tableNumber;
	private int maxSeats;
	private TableStatus tableStatus;
	
	public Table(int tableNumber, int maxSeats, TableStatus tableStatus) {
		super();
		this.tableNumber = tableNumber;
		this.maxSeats = maxSeats;
		this.tableStatus = TableStatus.FREE;
	}

}

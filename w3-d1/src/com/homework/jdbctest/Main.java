package com.homework.jdbctest;

import java.time.LocalDate;

public class Main {
		
	public static void main(String[] args) {
		try {
			
			DbConnection db = new DbConnection();
			
			Studenti s = new Studenti("Mario", "Rossi", Gender.M , LocalDate.of(2000, 11, 10), 7.5, 6, 9);
		} catch {
			return null;
		}
	}

}

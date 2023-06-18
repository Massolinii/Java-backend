package com.massolini.firesystem.model;

import java.util.List;
import java.util.concurrent.TimeUnit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "control_centers")
public class Center {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long name;
	private List<Place> places;
	
	public void printSignal(Alarm a) throws InterruptedException {
		switch (a.getSmoke()) {
		case ONE, TWO: {
			System.out.println("LOW SMOKE DETECTED - Please check: " + a.getId());
		}
		case THREE, FOUR, FIVE: {
			Place place = a.getPlace();
			String phone = place.getPhone();
			System.out.println("MEDIUM SMOKE LEVEL - Call number: " + phone);
			
		}
		case SIX: {
			System.out.println("HIGH SMOKE LEVEL - Calling the Fire Department");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Here they are coming...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("...🚒🚒🚒");
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + a.getSmoke());
		}

	}
}

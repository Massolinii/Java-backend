package com.epicode.workSpaceReservationApplication.model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "building")
@Access(AccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Building {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	    
	  @NonNull private String name;
	  @NonNull private String address;
	  
	  @ManyToOne // There will be multiple building in 1 city
	  @NonNull private City city;
	  
	  public Building(String name, String address, City city) {
	      this.name = name;
	      this.address = address;
	      this.city = city;
	  }
}

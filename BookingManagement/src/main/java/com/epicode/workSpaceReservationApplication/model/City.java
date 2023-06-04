package com.epicode.workSpaceReservationApplication.model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cities")
@Access(AccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class City {
	
	  @Id
	  @Column(columnDefinition = "BIGINT")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	    
	  private String name;
}

package com.epicode.workSpaceReservationApplication.model;

import java.util.List;

import com.epicode.workSpaceReservationApplication.enums.SpaceTypology;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "spaces")
@Access(AccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Space {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
	@NonNull private String name;
	private String description;
	@Column(nullable = false)private int maxGuests;
    
    @Enumerated(EnumType.STRING)
    private SpaceTypology typology;
    
    @ManyToOne // There will be many spaces in one building
    @JoinColumn(name = "building_id")
    private Building building;
    
    @OneToMany(mappedBy = "workspace", fetch = FetchType.EAGER)
    private List<Reservation> reservations;
    
    public Space(
            String name, String description, SpaceTypology typology,
            int maxGuests) {
        this.name = name;
        this.description = description;
        this.typology = typology;
        this.maxGuests = maxGuests;
    }
}

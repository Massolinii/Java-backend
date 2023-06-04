package com.epicode.workSpaceReservationApplication.model;

import java.util.List;

import com.epicode.workSpaceReservationApplication.enums.UserRole;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "users")
@Access(AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull private String username;
	@NonNull private String name;
	@NonNull private String email;
	@NonNull private String password;
	@NonNull @Enumerated(EnumType.STRING) private UserRole role;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

	public User(
            String username, String name, String email,
            String password, UserRole role) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}

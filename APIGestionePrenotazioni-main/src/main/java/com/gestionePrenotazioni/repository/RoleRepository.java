package com.gestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionePrenotazioni.model.ERole;
import com.gestionePrenotazioni.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}

package com.epicode.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.rest.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	// find ID
	public boolean existsById(Long id); 
	
	// mail già esistente
	public boolean existsByEmail(String email);

}

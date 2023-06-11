package com.epicode.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.rest.model.User;
import com.epicode.rest.repository.UserRepository;

@Service
public class UserService {
	
	// Dependency Injection Repository
	@Autowired private UserRepository repo;
	
	// get All Users
	public List<User> getAll() {
		return repo.findAll();
	}
	
	// get User by ID
	public User getById(Long id) {
		// Gestione Errore : ID non presente
		return repo.findById(id).get();
	}
	
	// create User
	public User create(User user) {
		// Gestione Errore : email già presente
		return repo.save(user);
		 
	}
	
	// update User (uguale al create, si differenzia dalla presenza o meno dell'ID)
	public User update(User user, Long id) {
		// Gestione Errore : ID non presente
		return repo.save(user);
	}
	
	// delete User
	public String remove(Long id) {
		// Gestione Errore : ID non presente
		repo.deleteById(id);
		return "User deleted";
	}

}

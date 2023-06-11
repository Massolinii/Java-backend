package com.epicode.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.rest.model.User;
import com.epicode.rest.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		// Metodo 1 : senza ResponseEntity
		// return userService.getAll();
		
		// Metodo 2 : Invia anche l'HTTP Status code della risposta
		// return new ResponseEntity(userService.getAll(), HttpStatus.OK);
		
		// Metodo 3 : Come il 2, ma lo status è prima del body della risposta
		return ResponseEntity.ok(userService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.create(user));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
		return ResponseEntity.ok(userService.update(user, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		return ResponseEntity.ok(userService.remove(id));
	}
	
}

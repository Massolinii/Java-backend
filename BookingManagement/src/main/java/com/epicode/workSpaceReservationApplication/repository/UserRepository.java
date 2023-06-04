package com.epicode.workSpaceReservationApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.epicode.workSpaceReservationApplication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String nome);
	
	@Query("SELECT COUNT(u) > 0 FROM User u WHERE u.role = 'ADMIN'")
    boolean selectAdminUsers();
	
	@Query("SELECT u FROM User u WHERE (SELECT COUNT(r) FROM Reservation r WHERE r.user = u) < 1")
    List<User> findAllWithNoRes();

	
}

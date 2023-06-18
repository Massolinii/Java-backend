package com.massolini.firesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.massolini.firesystem.model.Center;

@Repository
public interface CenterRepository extends JpaRepository<Center, Long>{

}

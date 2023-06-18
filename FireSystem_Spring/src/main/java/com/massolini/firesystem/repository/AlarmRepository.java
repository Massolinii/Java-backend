package com.massolini.firesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.massolini.firesystem.model.Alarm;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long>{

}

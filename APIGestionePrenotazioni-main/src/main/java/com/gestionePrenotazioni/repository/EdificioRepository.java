package com.gestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionePrenotazioni.model.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

}

package com.gestionePrenotazioni.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gestionePrenotazioni.model.Edificio;

@Repository
public interface EdificioPagebleRepository extends PagingAndSortingRepository<Edificio, Long>{

}

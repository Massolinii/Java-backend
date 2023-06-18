package com.gestionePrenotazioni.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gestionePrenotazioni.model.PrenotazionePostazione;
import com.gestionePrenotazioni.model.Utente;

@Repository
public interface UtentiPagebleRepository extends PagingAndSortingRepository<Utente, Long>{

}

package com.gestionePrenotazioni.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gestionePrenotazioni.model.PrenotazionePostazione;

@Repository
public interface PrenotazioniPagebleRepository extends PagingAndSortingRepository<PrenotazionePostazione, Long>{

}

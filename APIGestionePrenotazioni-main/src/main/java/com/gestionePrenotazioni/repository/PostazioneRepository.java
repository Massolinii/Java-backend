package com.gestionePrenotazioni.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestionePrenotazioni.Enums.TipoPostazione;
import com.gestionePrenotazioni.model.Edificio;
import com.gestionePrenotazioni.model.Postazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long>{

	@Query("SELECT p From Postazione p WHERE p.edificio.citta= :cittaP AND p.tipoPostazione= :tipo")
	 public List<Postazione> cercaPostazionePerTipoCitta(String cittaP,TipoPostazione tipo);
	

	
	@Query("SELECT COUNT(*) FROM Postazione p WHERE p.edificio = :e")
	public int cercaNumeroPostazioniAzienda(Edificio e);
}

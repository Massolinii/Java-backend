package controller;

import java.time.LocalDate;

import Enumerations.GenereConcerto;
import Enumerations.Sesso;
import Enumerations.StatoPartecipazione;
import Enumerations.TipoEvento;
import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioniDAO;
import dao.PersonaDAO;
import model.*;

public class MainProject {

	public static void main(String[] args) {
		
		Location spiaggia = new Location();
		spiaggia.setNome("Epicode Beack");
		spiaggia.setCitta("Roma");
		
		LocationDAO spiaggiaDao = new LocationDAO();
		spiaggiaDao.save(spiaggia);
		
		Concerto madonna = new Concerto();
		madonna.setTitolo("Madonn");
		madonna.setDataEvento(LocalDate.now());
		madonna.setDescrizione("Concerto della Madonna");
		madonna.setGenere(GenereConcerto.ROCK);
		madonna.setInStreaming(true);
		madonna.setLocation(spiaggia);
		madonna.setNumeroMassimoPartecipanti(10);
		madonna.setTipoEvento(TipoEvento.PRIVATO);
		
		EventoDAO evd1 = new EventoDAO();
		evd1.save(madonna);
		
		Persona p1 = new Persona("Mario", "Rossi", "m.rossi@mario.com", LocalDate.of(1999, 01, 29), Sesso.MASCHIO);
		
		PersonaDAO ped1 = new PersonaDAO();
		ped1.save(p1);
		
		Partecipazione par1 = new Partecipazione(p1, madonna, StatoPartecipazione.CONFERMATA);
		PartecipazioniDAO pard1 = new PartecipazioniDAO();
		pard1.save(par1);
	}

}

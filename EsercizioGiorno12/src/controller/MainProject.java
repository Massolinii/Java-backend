package controller;

import java.time.LocalDate;
import java.util.Set;

import dao.EventoDAO;
import model.*;
import utils.Genere;
import utils.TipoEvento;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EventoDAO;

public class MainProject {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");
		EntityManager em = emf.createEntityManager();

			Evento ConcUno = new Concerto(Genere.CLASSICO, true);
			ConcUno.setTitolo("Concerto Non Importa");
			ConcUno.setDataEvento(LocalDate.of(2023, 9, 23));
			ConcUno.setDescrizione("musica da giovani");
			ConcUno.setTipoEvento(TipoEvento.PUBBLICO);
			ConcUno.setNumeroMassimoPartecipanti(50);
			ConcUno.setLocation(new Location("Palapanini", "Modena"));
			
			EventoDAO eventoDAO = new EventoDAO();
			eventoDAO.save(ConcUno);

	}

}

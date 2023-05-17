package utils;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
//		try {
//			Evento e1 = new Evento();
//			e1.setDataEvento(LocalDate.of(2023, 01, 29));
//			e1.setDescrizione("Pizzata");
//			e1.setNumeroMassimoPartecipanti(20);
//			e1.setTipoEvento(tipoEvento.PUBBLICO);
//			e1.setTitle("Pizza Pazza Party a Pero");
//			inserisciEvento(e1);
//		} catch (Exception e) {
//			e.printStackTrace(); 
//		} finally {
//			em.close();
//			emf.close();
//		}
		
		Evento e1 = leggiEvento(1);
		e1.setTitle("Ciao");
		modificaEvento(e1);
		leggiEvento(1);
		
		
		
	}
	
	public static void inserisciEvento(Evento e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println(e.getTitle() + "aggiunto al Database!");
	}
	
	public static void modificaEvento(Evento e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	public static void eliminaEvento(Evento e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
	}
	
	public static Evento leggiEvento(Integer id) {
		em.getTransaction().begin();
		Evento e = em.find(Evento.class, id);
		em.getTransaction().commit();
		System.out.println(e);
		return e;
	}

}

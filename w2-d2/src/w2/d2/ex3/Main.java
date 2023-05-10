package w2.d2.ex3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static Logger log = LoggerFactory.getLogger(Main.class);
	private static Map<String, String> rubrica = new HashMap<String, String>();

	public static void main(String[] args) {

		try {
			aggiungiContatto("Mario","123456");
			aggiungiContatto("Giuseppe","756564");
			aggiungiContatto("Franco","000001");
			
			System.out.println(ricercaPersona("756564"));
			System.out.println(ricercaNumero("Franco"));
			
			rimuoviContatto("Giuseppe");
			stampaRubrica();
			
		} catch (Exception e) {
			log.error("ERRORE " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void aggiungiContatto(String nome, String telefono) throws Exception {
		if (rubrica.containsKey(nome)) {
			throw new Exception("Contatto già presente in rubrica!");
		} else {
			rubrica.put(nome, telefono);
		}
	}
	
	private static void rimuoviContatto(String nome) {
		rubrica.remove(nome);
	}
	
	private static String ricercaPersona(String telefono) {
		for (String nome : rubrica.keySet()) {
			if(rubrica.get(nome).equals(telefono)) {
				return nome;
			}
		}
		return null;
	}
	
	private static String ricercaNumero(String nome) {
		return rubrica.get(nome);
	}
	
	private static void stampaRubrica() {
		System.out.println("**** STAMPA RUBRICA ****");
		Set<String> key = rubrica.keySet();
		
		for (String nome : key) {
			System.out.println("  - " + nome + " num." + rubrica.get(nome));
		}
	}
	
	
	

}

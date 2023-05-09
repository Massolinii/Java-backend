

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	static Logger log = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		
//		log.info("Test Info Logger");
//		log.error("Test Error Logger");
//		log.warn("Test Warning Logger");
//		log.debug("Test Debug Logger");
		
		testCollection();
	}
		
		public static void testCollection() {
			Collection<String> s = new ArrayList<String>();
			Collection<Integer> c = new ArrayList<Integer>();
			
			s.add("Primo Elemento");
			s.add("Secondo Elemento");
			s.add("Terzo Elemento");
			
			boolean cont = s.contains("Secondo Elemento");
			log.info("Contains 'Secondo Elemento' : " + cont);
			
			boolean isEmp = s.isEmpty();
			log.info("Collection isEmpty: " + isEmp); 
			
			int size = s.size();
			log.info("Collection size: " + size); 
			
			s.forEach(e -> log.info(e));
			
			c.remove("Primo Elemento");
			c.clear();
			
			isEmp = c.isEmpty();
			log.info("Collection isEmpty: " + isEmp);
			}
		
		public static void testList() {
			List<String> l = new ArrayList<String>();
			// Memorizzati in base all'ordine di inserimento
			// I valori POSSONO essere duplicati
			// Puoi aggiungere specificando un indice
			
			l.add("Primo Elemento");
			l.add("Secondo Elemento");
			l.add("Terzo Elemento");
			
			// I METODI SONO EREDITATI DA COLLECTION (SUPER DI LIST)
			
			boolean cont = l.contains("Secondo Elemento");
			log.info("Contains 'Secondo Elemento' : " + cont);
		}

}



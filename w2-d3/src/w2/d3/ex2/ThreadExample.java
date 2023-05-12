package w2.d3.ex2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ThreadExample implements Runnable {
	
	int sommaParziale = 0;
	
	private int[] arrElementi;
	private int indiceIniziale;
	private int numeroElementi;
	static List<Integer> listaRisultati;
	
	private Logger log = LoggerFactory.getLogger(ThreadExample.class);

	public ThreadExample(int[] arrElementi, int indiceIniziale, int numeroElementi) {
		super();
		this.arrElementi = arrElementi;
		this.indiceIniziale = indiceIniziale;
		this.numeroElementi = numeroElementi;
	}

	@Override
	public void run() {
		
		for (int i = indiceIniziale; i < indiceIniziale + numeroElementi; i++) {
			sommaParziale += arrElementi[i];
		}
		log.info("Somma parziale ");
		listaRisultati.add(sommaParziale);
		
	}

}

package w2.d3.ex2;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static int[] arrayElementi;
	
	public static void main(String[] args) {
		
		arrayElementi = inizializzaArray(3000);
		
		final Logger log = LoggerFactory.getLogger(ThreadExample.class);
		
		Thread t1 = new Thread(new ThreadExample(arrayElementi, 0, 1000));
		Thread t2 = new Thread(new ThreadExample(arrayElementi, 1000, 1000));
		Thread t3 = new Thread(new ThreadExample(arrayElementi, 2000, 1000));
		
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		Integer sommaTotale = 0;
		for (Integer v : ThreadExample.listaRisultati) {
			sommaTotale += v;
		}
	}
	
	private static int[] inizializzaArray(int size) {
		
		Random rand = new Random();
		int[] arr = new int[size];
		
		for (int i= 0; i < size; i++) {
			arr[i] = rand.nextInt(100);
		}
		return arr;

	}

}

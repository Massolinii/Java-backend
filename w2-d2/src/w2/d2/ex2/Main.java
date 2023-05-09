package w2.d2.ex2;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		// generazioneRand();
		// arrayRovesciato();
		
		ArrayList<Integer> listaZeroDieci = new ArrayList();
		listaZeroDieci.add(1);
		listaZeroDieci.add(2);
		listaZeroDieci.add(3);
		listaZeroDieci.add(4);
		listaZeroDieci.add(5);
		listaZeroDieci.add(6);
		listaZeroDieci.add(7);
		listaZeroDieci.add(8);
		listaZeroDieci.add(9);
		listaZeroDieci.add(10);

		boolean checkTrue = true;
		boolean checkFalse = false;
		
		pariDispari(listaZeroDieci, checkTrue);
		pariDispari(listaZeroDieci, checkFalse);

		
	}
	
	public static void generazioneRand() {
		
		Random rand = new Random();
		ArrayList<Integer> numeriCasuali = new ArrayList();
		
		System.out.print("Inserisci quanti numeri casuali da 0 a 100 creare: ");
		int n = Integer.parseInt(scan.nextLine());
		
		
		for ( int i = 0; i < n; i++) {
			int int_random = rand.nextInt(25);
			numeriCasuali.add(int_random);
		}
		System.out.println(numeriCasuali);
	}
	
	public static void arrayRovesciato() {
		
		ArrayList<String> daRovesciare = new ArrayList<String>();
		daRovesciare.add("Primo Elemento");
		daRovesciare.add("Secondo Elemento");
		daRovesciare.add("Terzo Elemento");
		daRovesciare.add("Quarto Elemento");
		daRovesciare.add("Quinto Elemento");
		
		System.out.println("ArrayList originale : ");
		System.out.println(daRovesciare);
		
		System.out.println("ArrayList rovesciato : ");
	    Collections.reverse(daRovesciare);
	    System.out.println(daRovesciare);
		}
	
	public static void pariDispari(ArrayList<?> list, boolean y) {
		if (y == true) {
			for (int i = 0; i < list.size() ; i = i+2) {
				System.out.println(list.get(i));
			}
		} else {
			for (int i = 1; i < list.size() ; i = i+2) {
				System.out.println(list.get(i));
		}
	}
	}
}

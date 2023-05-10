package w2.d2.ex1;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Inserisci il futuro numero di parole: ");
		
		int numPar = Integer.parseInt(scan.nextLine());
		
		Set<String> parole = new HashSet<>();
		Set<String> parUniche = new HashSet<>();
		Set<String> parDuplicate = new HashSet<>();
		
		System.out.println("Inserisci " + numPar + " parole: ");
		for (int i = 0; i < numPar; i++) {
			String parola = scan.nextLine();
			parole.add(parola);
			
			if (parUniche.contains(parola)) {
				parDuplicate.add(parola);
			} else {
				parUniche.add(parola);
			}
		}
		
		System.out.println("RISULTATI :");
		System.out.println("Parole duplicate: ");
		for (String parola : parDuplicate) {
			System.out.println(parola);
		}
		
		System.out.println("Numero parole uniche: " + parUniche.size());
		System.out.println("Parole uniche :");
		for (String parola : parUniche) {
			System.out.println(parola);
		}
		
		scan.close();
	}
}

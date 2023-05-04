package exercise_1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner an = new Scanner(System.in);
		System.out.print("Inserisci un anno per controllare se è bisestile: ");
		int sceltaAnno = an.nextInt();
		
		System.out.println(annoBisestile.calcoloBisestile(sceltaAnno));
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci una stringa da controllare se la lunghezza è pari o dispari: ");
		String sceltaStringa = sc.next();

		System.out.println(stringaPariDispari.pariDispari(sceltaStringa));
		
	}
}

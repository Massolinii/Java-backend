package exercise_2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner n = new Scanner(System.in);
		System.out.print("Inserisci un numero da 0 a 3: ");
		int sceltaNumero = n.nextInt();
		
		System.out.println(zeroToThree.checkNumber(sceltaNumero));
	}
}
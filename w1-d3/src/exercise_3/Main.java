package exercise_3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        String inputString;

        while (true) {
            System.out.print("Inserisci una stringa (:q per uscire): ");
            inputString = scanner.nextLine();

            if (inputString.equals(":q")) {
                break;
            }

            for (int i = 0; i < inputString.length(); i++) {
                System.out.print(inputString.charAt(i));
                if (i != inputString.length() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();
        }

        scanner.close();
    }
}
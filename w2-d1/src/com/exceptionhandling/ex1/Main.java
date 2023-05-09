package com.exceptionhandling.ex1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[5];

        Random random = new Random();

        for (int i = 0; i < array.length ; i++) {
            array[i] = random.nextInt(10) + 1;
        }

        stampaArray(array);

        Scanner scanner = new Scanner(System.in);
        int valoreInserito = 0;

        do {

            try {
                System.out.println("Inserisci numero da 1 a 10. Premi 0 per terminare.");
                valoreInserito = scanner.nextInt();

                if (valoreInserito >= 0 && valoreInserito <= 10) {
                    if (valoreInserito == 0) {
                        break;
                    }

                    System.out.println("Inserisci la posizione dell'array dove vuoi inserire '" + valoreInserito + "'");
                    int posizione = scanner.nextInt() - 1;

                    if (posizione >= 0 && posizione < array.length) {
                        array[posizione] = valoreInserito;
                        stampaArray(array);
                    } else {
                        System.out.println("Posizione invalida. Riprova.");
                    }
                } else {
                    System.out.println("Valore non valido. Inserisci un numero compreso tra 0 e 10.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Valore non valido. Inserisci un numero intero.");
                scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Valore non valido. Inserisci un numero intero.");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }

        } while (valoreInserito != 0);

        scanner.close();
    }

    private static void stampaArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }
}
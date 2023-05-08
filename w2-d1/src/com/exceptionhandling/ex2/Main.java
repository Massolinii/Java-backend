package com.exceptionhandling.ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int valoreInserito = 0;
        double km = 0;
        double lt = 0;

        do {

            try {
                System.out.println("Inserisci la quantità di km percorsi :");
                km = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valore non valido. Inserisci un km valido.");
                km = scanner.nextDouble();
            }

            try {
                System.out.println("Inserisci la quantità di benzina agricola :");
                lt = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valore non valido. Inserisci un lt valido.");
                lt = scanner.nextDouble();
            }

            double consumi = (km / lt);
            System.out.println("Hai consumato " + consumi);
        } while (valoreInserito != 0);

        scanner.close();
    }
}

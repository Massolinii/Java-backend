package exercise_1;

public class stampaDueRettangoli {
	public static void stampaDueRett(Rettangolo rettangolo1, Rettangolo rettangolo2) {		
		System.out.println("Rettangolo 2: ");
		stampaRettangolo.stampaRett(rettangolo1);
		System.out.println("Rettangolo 3: ");
		stampaRettangolo.stampaRett(rettangolo2);
		System.out.println("Somma delle aree: " + (rettangolo1.calcolaArea() + rettangolo2.calcolaArea()));
		System.out.println("Somma dei perimetri: " + (rettangolo1.calcolaPerimetro() + rettangolo2.calcolaPerimetro()));
	}
}

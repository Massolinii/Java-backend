package exercise_1;

public class Main {
	public static void main(String[] args) {
		Rettangolo rettangolo1 = new Rettangolo(3, 5);
		Rettangolo rettangolo2 = new Rettangolo(4, 6);
		Rettangolo rettangolo3 = new Rettangolo(2, 3);
		
		System.out.println("[SINGOLO] Rettangolo 1: ");
		stampaRettangolo.stampaRett(rettangolo1);
		
		System.out.println("----------------");
		
		System.out.println("[DOPPIO] Rettangolo 2+3: ");
		stampaDueRettangoli.stampaDueRett(rettangolo2, rettangolo3);
	}
}

package exercise_1;

public class Rettangolo {
	public double altezza;
	public double larghezza;

	public Rettangolo(double altezza, double larghezza) {
		this.altezza = altezza;
		this.larghezza = larghezza;
	}
	
	public double calcolaArea() {
		return altezza * larghezza;
	}
	
	public double calcolaPerimetro() {
		return (altezza + larghezza) * 2;
	}
}

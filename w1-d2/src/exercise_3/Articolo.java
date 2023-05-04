package exercise_3;

public class Articolo {
	private String codiceArticolo;
	private String descrizione;
	private double prezzo;
	private int pezziDisponibili;
	
	public Articolo(String codiceArticolo, String descrizione, double prezzo, int pezziDisponibili) {
		this.codiceArticolo = codiceArticolo;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.pezziDisponibili = pezziDisponibili;
	}
}

package exercise_2;
import java.util.ArrayList;
import java.util.List;

public class SIM {
	private String numeroDiTelefono;
    private double credito;
    private List<Chiamata> chiamate;

    public SIM(String numeroDiTelefono) {
        this.numeroDiTelefono = numeroDiTelefono;
        this.credito = 0.0;
        this.chiamate = new ArrayList<>();
    }

    public void aggiungiChiamata(int durata, String numeroChiamato) {
    	// V per evitare che venga overpopolato l'array V //
        if (chiamate.size() == 5) {
            chiamate.remove(0);
        }
        chiamate.add(new Chiamata(durata, numeroChiamato));
    }

    public void ricarica(double importo) {
        this.credito += importo;
    }

    public void stampaDatiSIM() {
        System.out.println("Numero di telefono: " + numeroDiTelefono);
        System.out.println("Credito residue: " + credito + " Euro");
        System.out.println("Ultime 5 chiamate:");
        for (Chiamata chiamata : chiamate) {
            System.out.println("  Durata: " + chiamata.durata + " minuti, Numero chiamato: " + chiamata.numeroChiamato);
        }
    }
}

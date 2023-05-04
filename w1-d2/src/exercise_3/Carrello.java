package exercise_3;
import java.util.ArrayList;
import java.util.List;

class Carrello {
    private Cliente clienteAssociato;
    private List<Articolo> elencoArticoli;
    private double totale;

    public Carrello(Cliente clienteAssociato) {
        this.clienteAssociato = clienteAssociato;
        this.elencoArticoli = new ArrayList<>();
        this.totale = 0.0;
    }

    public void aggiungiArticolo(Articolo articolo) {
        elencoArticoli.add(articolo);
        totale += articolo.getPrezzo();
    }

    public void rimuoviArticolo(Articolo articolo) {
        if (elencoArticoli.remove(articolo)) {
            totale -= articolo.getPrezzo();
        }
    }
}
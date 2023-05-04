package exercise_3;

public class Main {
	public static void main(String[] args) {
		Articolo articolo1 = new Articolo("001", "Maglietta", 13.99, 100);
		Articolo articolo2 = new Articolo("002", "Jeans", 30.99, 50);
		Articolo articolo3 = new Articolo("003", "Cappellino", 7.50, 80);
		
		Cliente cliente1 = new Cliente("C-01", "Mario", "Rossi", "ilmarione@mail.net", "17/04/2018");
		Cliente cliente2 = new Cliente("C-02", "Paolo", "Scavalcacinghie", "pasca@mail.net", "31/12/2022");
		
        Carrello carrello = new Carrello(cliente1);
        carrello.aggiungiArticolo(articolo1);
        carrello.aggiungiArticolo(articolo2);
	}
}

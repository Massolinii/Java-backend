package exercise_2;

public class Main {
    public static void main(String[] args) {
        SIM mioNumero = new SIM("3271666844");

        mioNumero.aggiungiChiamata(5, "0909483051");
        mioNumero.aggiungiChiamata(10, "19841568");
        mioNumero.aggiungiChiamata(7, "+3915662526");
        mioNumero.aggiungiChiamata(3, "1234445556");
        mioNumero.aggiungiChiamata(15, "0000000001");
        
        mioNumero.ricarica(13.55);

        mioNumero.stampaDatiSIM();
    }
}
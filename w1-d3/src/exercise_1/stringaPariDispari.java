package exercise_1;

public class stringaPariDispari {
	
	public static String pariDispari(String str) {
		int result = str.length() % 2;
		if (result == 0) {
			return "Questa stringa è di lunghezza pari.";
		} else {
			return "Questa stringa è di lunghezza dispari.";
		}
	}
	 
}

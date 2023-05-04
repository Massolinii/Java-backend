package exercise_2;

public class zeroToThree {
	public static String checkNumber(int n) {
		switch (n) {
		case 0 : return "Zero";
		case 1 : return "Uno";
		case 2 : return "Due";
		case 3 : return "Three";
		default: return "Valore errato";
		}
	}
}

package exercise_1;

public class annoBisestile {
	
	public static boolean calcoloBisestile(int anno) {
		int result = anno % 4;
		if (result == 0) {
			if (anno % 100 != 0 || anno % 400 == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}

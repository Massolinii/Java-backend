package multimedia;

public class image extends mediaElement implements brightnessInterface{
	
	private int brightness = 5;

	public image(String titolo, int bright) {
		super(titolo);
		this.setBrightness(bright);
	}
	
	
	public int getBrightness() {
		return brightness;
	}
	
	public void setBrightness(int i) {
		this.brightness = i;
		
	}

	@Override
	public void brightnessUp(int n) {
		this.setBrightness(this.getBrightness() + n);	
	}

	@Override
	public void brightnessDown(int n) {
		this.setBrightness(this.getBrightness() - n);
	}
	
	@Override
	public String toString() {
		return "// MEDIA: Image: " + this.title;
	}
	
	public void show() {
		int bright = this.getBrightness();
		
		String displayBrightness = "";
		for (int j=0; j<bright; j++) {
		displayBrightness += "*";
		}
		
		System.out.println(this.toString() + " -- Brightness: " + displayBrightness);
	}


}
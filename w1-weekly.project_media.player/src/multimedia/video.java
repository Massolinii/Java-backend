package multimedia;

public class video extends mediaElement implements volumeInterface, brightnessInterface {
	
	private int volume = 5;
	private int duration;
	private int brightness = 5;
	
	public video(String title, int duration, int bright) {
		super(title);
		this.setBrightness(bright);
		this.setDuration(duration);
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int newVolume) {
		this.volume = newVolume;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int newBrightness) {
		this.brightness = newBrightness;
	}
	
	@Override
	public void volumeUp(int n) {
		this.setVolume(this.getVolume() + n);
		
	}

	@Override
	public void volumeDown(int n) {
		this.setVolume(this.getVolume() - n);
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
		return "// MEDIA: Video: " + this.title;
	}
	
	public void playVideo() {
		
		int vol = this.getVolume();
		
		String displayVolume = "";
		for (int j=0; j<vol; j++) {
		displayVolume += "!";
		}
		
		int bright = this.getBrightness();
		String displayBrightness = "";
		for (int j=0; j<bright; j++) {
		displayBrightness += "*";
		}
		
		int dur = this.getDuration();
		
		for (int i = 0; i<dur; i++) {
            System.out.println(this.toString() + " -- Duration: " + getDuration()  + " -- Volume: " + displayVolume + " -- Brightness: " + displayBrightness);
        }			
	}
}
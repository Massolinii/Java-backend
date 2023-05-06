package multimedia;

public class audio extends mediaElement implements volumeInterface {
	
	private int volume = 5;
	private int duration;
	
	public audio(String title, int duration) {
		super(title);
		this.setDuration(duration);
	}
	
	public static void main(String[] args) {

	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void setVolume(int newVolume) {
		this.volume = newVolume;
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
	public String toString() {
		return "// MEDIA: Audio: " + this.title;
	}
	
	public void playAudio() {
		int vol = this.getVolume();
		
		String displayVolume = "";
		for (int j=0; j<vol; j++) {
		displayVolume += "!";
		}
		
		int dur = this.getDuration();
		
		for (int i = 0; i<dur; i++) {
            System.out.println(this.toString() + " -- Duration: " + getDuration() + " -- Volume: " + displayVolume);
        }
	}
}

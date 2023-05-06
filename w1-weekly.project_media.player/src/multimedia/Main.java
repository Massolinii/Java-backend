package multimedia;

public class Main {
	
	public static void main(String[] args) {
        System.out.println("// ---------------------------------------------------------------*");
		audio a1 = new audio("Mamma Mia", 5);
        a1.volumeUp(3);
        a1.setDuration(3);
        a1.playAudio();
        System.out.println("// ---------------------------------------------------------------*");
		
		image i1 = new image("Casa al Mare", 6);
		i1.setBrightness(2);
		i1.show();
		System.out.println("// ---------------------------------------------------------------*");
		
		video v1 = new video("Comunione Roberto", 5, 5);
		v1.playVideo();
	}
}
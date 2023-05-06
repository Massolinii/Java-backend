package multimedia;

public abstract class mediaElement {
	
	public String title;

	public mediaElement(String title) {
		this.title = title;
	}
	
	public String toString() {
		return "Media : " + title;
	}
	
}


package w2.d3.ex1;

public class ThreadSimboli {

	public static void main(String[] args) {
		
		ThreadExample t1 = new ThreadExample("#");
		ThreadExample t2 = new ThreadExample("*");
		
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		
		th1.start();
		th2.start();
	}
}
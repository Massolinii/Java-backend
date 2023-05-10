package w2.d3.ex1;

public class ThreadSimboli {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new ThreadSimbolo("*", 10, 1000));
		Thread thread2 = new Thread(new ThreadSimbolo("#", 10, 1000));
		
		thread1.start();
		thread2.start();
	}
}

class ThreadSimbolo implements Runnable {
	private final String simbolo;
	private final int ripetizioni;
	private final int intervallo;
	
	public ThreadSimbolo(String simbolo, int ripetizioni, int intervallo) {
		this.simbolo = simbolo;
		this.ripetizioni = ripetizioni;
		this.intervallo = intervallo;
	}
	
	public void run() {
		for (int i = 0; i < ripetizioni; i++) {
			System.out.println(simbolo);
			
			try {
				Thread.sleep(intervallo);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		

	}
}

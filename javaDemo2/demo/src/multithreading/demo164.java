package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo164 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(6);
		
		Runnable target = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("[" + Thread.currentThread().getName()
						+ "] " + i);
			}
		};
		
		pool.submit(target);
		pool.submit(target);
		
		if (!pool.isShutdown()) {
			pool.shutdown();
			System.out.println("trying to close the thread pool");
		}
	}
}

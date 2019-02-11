package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*  */
public class demo161 extends Thread {
	public static void main(String[] args) {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(NORM_PRIORITY);
		
		new Producer(bq).start();
		new Consumer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
	}
}

class Producer extends Thread {
	private BlockingQueue<String> bq;
	
	public Producer(BlockingQueue<String> bq) {
		this.bq = bq;
	}
	
	@Override
	public void run() {
		String[] strs = {
			"Java",
			"Struts",
			"Spring"
		};
		
		System.out.println("produce---start");
		
		for (int i = 0; i < 999999; i++) {
			try {
				bq.put(strs[i % 3]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName()
					+ " produce " + bq);
		}
	}
}

class Consumer extends Thread {
	private BlockingQueue<String> bq;
	
	public Consumer(BlockingQueue<String> bq) {
		this.bq = bq;
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println("consumer---start");
			try {
				bq.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName()
					+ " consume " + bq);
		}
	}
}

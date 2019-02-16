package multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class demo165 {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(10);
		
		pool.submit(new PrintAction(1, 100));
		try {
			pool.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		pool.shutdown();
	}
}

class PrintAction extends RecursiveAction {

	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 50;
	private int start;
	private int end;
	
	public PrintAction(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if (end -start < THRESHOLD) {
			for (var i = start; i < end; i++) {
				System.out.println("[" + Thread.currentThread().getName() + "]"
						+ i);
			}
		} else {
			// 分解任务
			int middle = (start + end) /  2;
			
			PrintAction left = new PrintAction(start, middle);
			PrintAction right = new PrintAction(middle, end);
			
			left.fork();
			right.fork();
		}
	}
}

package multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* 使用 Callable 和 Future 创建线程 */
public class demo146 {
	public static void main(String[] args) {
		/* 创建 */
		FutureTask<Integer> task = new FutureTask<Integer>(()->{
			Integer i = 1;
			for (; i < 100; i++) {
				print(i);
			}
			return i;
		});
		
		for (int i = 0; i < 100; i++) {
			print(i);
			
			if (i == 20) {
				new Thread(task, "新线程0").start();
				new Thread(task, "新线程1").start();
				new Thread(task, "新线程2").start();
				new Thread(task, "新线程3").start();
				new Thread(task, "新线程4").start();
				new Thread(task, "新线程5").start();
				new Thread(task, "新线程6").start();
			}
			
//			System.out.println("[ task is canceled: " + task.isCancelled() + "]");
		}
		
		try {
			System.out.println("[return: " + task.get() + "]");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	static void print(int i) {
		System.out.println("[" + Thread.currentThread().getName()
				+ "---"
				+ i + "]");
	}
}

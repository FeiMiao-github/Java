package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* 使用阻塞队列控制线程通信 BlockingQueue */
public class demo160 {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
		
			bq.put("Java");
			bq.put("Java");
			bq.put("Java");
			/* 阻塞 main 线程 */
			System.out.println(1234);
	}
}

/* 放入元素、取出元素可以很好的控制线程通信 */

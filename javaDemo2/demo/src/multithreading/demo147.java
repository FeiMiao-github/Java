package multithreading;

/* 如果希望调用子线程start方法后子线程立即开始执行， 程序可以使用Thread.sleep(1)
 * 来让当前线程睡眠1ms */
public class demo147 {
	public static void main(String[] args) {
		Thread td = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("[" + Thread.currentThread().getName() + ": " + i + "]");
			}

		}, "Threade haha");
		
		Thread td1 = new Thread(()-> {
			double t = 0;
			while (true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("time: %2.1f(s)\n", (t = t + 0.1));
			}
		}, "Thread2"
		);
		
		td1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < 100; i++) {
			System.out.println("[" + Thread.currentThread().getName() + ": " + i + "]");

			if (i == 10) {
				td.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

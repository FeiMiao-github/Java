package multithreading;

/* 线程组和未处理的异常 */
public class demo162 {
	/* 创建线程组 */
	static ThreadGroup tg1 = new ThreadGroup("线程组1");
	
	public static void main(String[] args) {
		
		Thread[] td = new Thread[3];
		
		td[0] = new Thread(tg1, ()-> {
			for (int i = 0; i < 50; i++) {
				print("线程1");
			}
		});
		
		td[1] = new Thread(tg1, ()-> {
			for (int i = 0; i < 50; i++) {
				print("线程2");
			}
		});
	
		td[2] = new Thread(tg1, ()-> {
			for (int i = 0; i < 50; i++) {
				print("线程3" + ": " + Thread.currentThread().getThreadGroup());
			}
		});
		
		for (var t: td) {
			t.start();
		}
	}
	
	public static void print(String s) {
		System.out.println(s + "[" + 
				tg1.activeCount() + "]");
	}
}

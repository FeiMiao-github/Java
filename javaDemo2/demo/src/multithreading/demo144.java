package multithreading;

/* 继承Thread创建线程类 */
public class demo144 extends Thread {
	private int i;
	
	@Override
	public void run() {
		for (;i < 100; i++) {
			/* 继承Thread类时可以使用this获取当前线程 */
			System.out.println(getName() + "【" + i + "】");
		}
	}
	
	public static void main(String[] args) {
		for (int i =0; i < 100; i++) {
			/* Thread.currentThread() 方法获取当前线程 */
			System.out.println(Thread.currentThread().getName()
					+ "【" + i +  "】");
			if (i == 20) {
				new demo144().start(); // 使用start()启动线程
			}
		}
	}
}

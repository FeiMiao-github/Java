package multithreading;

/* 继承Runnable接口创建多线程 */
public class demo145 implements Runnable {
	private int i;

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "【" + i + "】");

			if (i == 20) {
				demo145 demo = new demo145();
				Thread td = new Thread(demo, "新线程");
				td.start();
				
				new Thread(() -> {
					for (int in = 1; in < 101; in++) {
						System.out.println("新线程2" + "【" + in + "】");
					}
				}, "新线程2").start();
			}
		}
	}

	@Override
	public void run() {
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "【" + i + "】");
		}
	}
}

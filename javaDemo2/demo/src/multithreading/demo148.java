package multithreading;

public class demo148 extends Thread {

	public demo148(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		new demo148("新线程").start();

		for (int i = 0; i < 100; i++) {

			System.out.println(Thread.currentThread().getName() + " " + i);

			if (i == 20) {
				demo148 demo = new demo148("调用了join方法的线程");
				
				/* 调用了join方法的线程执行完成之前， main线程处于阻塞状态 */ 
				demo.start();
				try {
					demo.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

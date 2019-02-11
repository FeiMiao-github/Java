package multithreading;

/* 线程让步 */
public class demo151 extends Thread {
	public static void main(String[] args) {
		demo151 demo1 = new demo151("线程1");
		demo151 demo2 = new demo151("线程2");
		demo151 demo3 = new demo151("线程3");
		
		demo1.setPriority(MAX_PRIORITY);
//		demo2.setPriority(NORM_PRIORITY);
//		demo3.setPriority(MIN_PRIORITY);
		
		demo1.start();
		demo2.start();
		demo3.start();
	}
	
	public demo151(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(getName()
					+ " " + i);
			
			if (i == 20) {
				Thread.yield();
			}
		}
	}
}

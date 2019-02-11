package multithreading;

public class demo149 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i >=0; i++) {
			System.out.println(this.getName()
					+ "[" + i + "]");
		}
	}
	
	/* setDaemon 设置为后台线程  */
	public static void main(String[] args) {
		demo149 demo = new demo149();
		/* 设置为后台线程， 必须在该线程启动之前设置 */
		demo.setDaemon(true);
		demo.start();
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()
					+ "[" + i + "]");
		}
	}
}

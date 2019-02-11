package multithreading;

/* 改变线程优先级 */
public class demo152 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + ", 优先级是: "
					+ getPriority() + ", 循环变量的值为: "
					+ i);
		}
	}
	
	public demo152(String name) {
		super(name);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			if (i == 10) {
				demo152 demo1 = new demo152("低级");
				demo1.start();
				System.out.println(Thread.currentThread().getName() 
						+ "创建之初的优先级: "
						+ demo1.getPriority());
				
				demo1.setPriority(MIN_PRIORITY);
			}
			
			if (i == 20) {
				demo152 demo2 = new demo152("高级");
				demo2.start();
				System.out.println(Thread.currentThread().getName() + 
						"创建之初的优先级: "
						+ demo2.getPriority());
				
				demo2.setPriority(MAX_PRIORITY);
			}
		}
	}
}

package multithreading;

/* 死锁 */
public class demo156 {
	A a = new A();
	B b = new B();
	
	public static void main(String[] args) {
		demo158 demo = new demo158();
		Thread.currentThread().setName("主线程");
		
		Thread t1 = new Thread(() -> {
			demo.a.bar(demo.b);
		}, "t1");
		
		t1.start();
		demo.b.foo(demo.a);
	}
}

class A {
	public synchronized void bar (B b) {
		System.out.println("[" + Thread.currentThread().getName() + "]"
				+ "进入class A 的bar 方法");
		
		System.out.println("[" + Thread.currentThread().getName() + "]"
				+ "将调用 class B 的 last 方法");
		
		b.last();
	}
	
	public synchronized void last() {
		System.out.println("进入 A 的 last 方法");
	}
}

class B {
	public synchronized void foo (A a) {
		System.out.println("[" + Thread.currentThread().getName() + "]"
				+ "进入class B 的foo 方法");
		
		System.out.println("[" + Thread.currentThread().getName() + "]"
				+ "将调用class A 的 last 方法");
		
		a.last();
	}
	
	public synchronized void last() {
		System.out.println("进入 B 的 last 方法");
	}
}
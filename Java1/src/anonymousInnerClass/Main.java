package anonymousInnerClass;

import org.junit.Test;

public class Main {
	interface FlyT{
		public void fly();
	}
	
	public void say(Bird b) {
		b.fly();
	}
	
	/* 匿名内部类 */
	@Test
	public void test() {
		say(new Bird() {
			public void fly() {
				System.out.println("I cannot fly, laughing!");
			}
		});
		
		FlyT io = new FlyT() {
			public void fly() {
				System.out.println("interfaceDemo");
			}
		};
		
		new FlyT() {
			public void fly() {
				System.out.println("interfaceDemo");
			}
		}.fly();
		
		new Bird() {
			public void fly() {
				System.out.println("I cannot fly, laughing!");
			}
		}.fly();
		
		io.fly();
	}
}

/** 访问内部类的构造器 */

public class demo44 {
	public static void main(String[] args) {
		demo44 demo = new demo44();
		demo.test();
	}
	
	public void test() {
		new OuterClass().new NStaticInnerClass();
		new OuterClass().new StaticInnerClass();
	}
}

/* 继承 非静态内部类并调用构造器 */
class SubClass extends OuterClass.NStaticInnerClass {
	public SubClass(OuterClass out) {
		out.super();
	}
	
	SubClass() {
		new OuterClass().super();
	}
}

/* 继承非静态内部类并调用构造器 */
class SubClass2 extends OuterClass.StaticInnerClass{
	public SubClass2() {
		new OuterClass().super();
	}
}

class OuterClass {
	class NStaticInnerClass {
		public NStaticInnerClass() {
			System.out.println(this.getClass().getName());
		}
	}
	
	class StaticInnerClass{
		public StaticInnerClass() {
			System.out.println(this.getClass().getName());
		}
	}
}

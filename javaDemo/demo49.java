
public class demo49 {
	public static void main(String[] args) {
		new demo49().test();
	}
	
	public void test() {
		int num1 = testInterface(()->3); // 省略return
		int num2 = testInterface2(t->t, 2); // 省略形式参数括号和 return
		
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
	}
	
	public int testInterface(Interface i) {
		return i.test();
	}
	
	public int testInterface2(Interface2 i, int num) {
		return i.test(num);
	}
}

interface Interface {
	public int test();
}

interface Interface2 {
	public int test(int num);
}


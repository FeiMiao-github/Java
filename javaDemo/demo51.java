public class demo51 {
	public static void main(String[] args) {
		new demo51().test();
	}
	
	public void test() {
		String string = "effitively final var";
		Display d1 = (a, b, c) -> {
			System.out.println(string + " start!"); //effectively final var
			return a + b + c;
		};
		d1.descript(); // 调用默认方法
		System.out.println("sum = " + d1.add(1, 2, 3));
		
		// string = "end!";
		System.out.println(string);
	}
}

interface Display {
	default void descript() {
		System.out.println("interface name " + getClass().getName() + " start!");
	}
	
	int add(int a, int b, int c);
}
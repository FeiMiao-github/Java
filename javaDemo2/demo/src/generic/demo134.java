package generic;

/* 泛型构造器 */
public class demo134 {
	public static void main(String[] args) {
		class Foo {
			public <T> Foo(T t) {
				System.out.println(t);
			}
		}
		
		String s = new String("泥嚎 ！");
		new <String> Foo(s);
		
		new <Double> Foo(12.3);
	}
}

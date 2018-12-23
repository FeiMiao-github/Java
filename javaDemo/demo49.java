
public class demo49 {
	public static void main(String[] args) {
		new demo49().test();
	}
	
	public void test() {
		int num1 = testInterface(()->3); // 省略return
		int num2 = testInterface2(t->t, 2);
		
		System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        
        /* Lambda 表达式变量 */
        Interface demo = () -> 10;
        System.out.println(demo.test());

        /* 使用强制类型对Lambda表达式进行强制类型转换 */
        Object o = (Interface) () -> 20;
        num1 = ((Interface) o).test();
        System.out.println("num1 = " + num1);
	}
	
	public int testInterface(Interface i) {
		return i.test();
	}
	
	public int testInterface2(Interface2 i, int num) {
		return i.test(num);
	}
}

@FunctionalInterface
interface Interface {
	public int test();
}

@FunctionalInterface
interface Interface2 {
	public int test(int num);
}
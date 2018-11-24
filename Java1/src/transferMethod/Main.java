package transferMethod;
/** @see https://www.zhihu.com/question/31203609 */
public class Main {
	/** @throws 转载自link地址 */
	
	public static void main(String[] args) {
		int num = 3;
		String str = "hello";
		
		/* 基本类型 */
		setValue(num);
		System.out.println("num = " + num);
		/* OUTPUT:
		 * num = 3
		 * */
		
		/* 没有提供改变自身方法的引用类型 */
		setString(str);
		System.out.println(str);
		/* OUTPUT:
		 * hello
		 * */
		
		/* 提供了改变自身方法的引用类型 */
		StringBuilder sB = new StringBuilder("Linux");
		setSB(sB);
		System.out.println(sB);
		/* OUTPUT:
		 * Linux奶啤!
		 * */
		
		/* 提供了修改自身的方法的引用类型,但是不使用.*/
		/* 而是使用赋值运算符*/
		setSb(sB);
		System.out.println(sB);
		/* OUTPUT:
		 * Linux奶啤!
		 * */
		
	}
	
	public static void setValue(int value) {
		value = 10;
	}
	
	public static void setString(String text) {
		text = "Windows";
	}
	
	public static void setSB(StringBuilder builder) {
		builder.append("奶啤!");
	}
	
	public static void setSb(StringBuilder builder) {
		builder = new StringBuilder("牛啤!");
	}

}

package enumerationMethod;

public class Main {

	public enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE};
	public static void main(String[] args) {
		Size s = Size.EXTRA_LARGE;
		Size s1 = Size.SMALL;
		System.out.println(s.equals(s1));
		System.out.println(s == s1);
		System.out.println(s == Size.EXTRA_LARGE);
		/*OUTPUT:
		 * false
		 * false
		 * true
		 * */
		
		SizeDemo testEnum = SizeDemo.SMALL;
		System.out.println(testEnum.toString());
		System.out.println(SizeDemo.SMALL.toString());
		
		/* toString() 的逆方法 valueOf()*/
		Size[] eleOfSize = Size.values();//返回一个包含有所有的Size元素的数组
		for (Size ele: eleOfSize) {
			System.out.println(ele);
		}
		System.out.println();
		
		s = Size.valueOf("SMALL");
		System.out.println(s);
		testEnum = SizeDemo.valueOf("SMALL");
		System.out.println(testEnum);
		
		
		System.out.println(SizeDemo.EXTRA_LARGE.ordinal());
		/* ordinal()返回 enum 中声明的枚举常量的位置， 从0开始计数 */
		
		
	}
}

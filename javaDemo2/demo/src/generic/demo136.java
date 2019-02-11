package generic;

/**
 * @author JZ
 * Java 改进的类型推断
 */
public class demo136 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MyUtil<String> ls = MyUtil.nil();
		
		/* 会有警告， 但是可以正常运行 */
		MyUtil mu = MyUtil.cons(23, MyUtil.nil());
	}
	
	static class MyUtil<E> {
		public static <Z> MyUtil<Z> nil() {
			return null;
		}
		
		public static <Z> MyUtil<Z> cons(Z head, MyUtil<Z> tail) {
			return null;
		}
		
		E head() {
			return null;
		}
	}
}
/* 泛型推断不是万能的 */
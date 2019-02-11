package throwable;

/* 使用throw 抛出异常 */
public class demo142 {
	public static void main(String[] args) {
		try {
			throwChecked(-3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		throwRuntime(3);// 可以捕获， 也可以不理会
	}

	public static void throwChecked(int a) throws Exception {
		if (a > 0) {
			throw new Exception("a 的值大于0");
		}
	}

	public static void throwRuntime(int a) {
		if (a > 0) {
			throw new RuntimeException("a 的值大于0");
		}
	}
}

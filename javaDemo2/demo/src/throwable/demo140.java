package throwable;

public class demo140 {
	public static void main(String[] args) {
		System.out.println(test());
	}
	
	@SuppressWarnings("finally")
	public static boolean test() {
		try {
			return true;
		} finally {
			return false;
		}
	}
}

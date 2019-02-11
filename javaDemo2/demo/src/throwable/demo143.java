package throwable;

/* 自定义异常类 */
public class demo143 {
	public static void main(String[] args) {
		try {
			new demo143().test(3);
		} catch (AuctionException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void test(int a) throws AuctionException {
		if (a > 0) {
			throw new AuctionException("a > 0");
		}
	}
}

class AuctionException extends Exception {
	public AuctionException() {}
	public AuctionException(String msg) {
		super(msg);
	}
}

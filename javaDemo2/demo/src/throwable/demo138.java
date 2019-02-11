package throwable;

/* 异常处理机制 */
public class demo138 {
	public static void main(String[] args) {
		try {
			int aInt = Integer.parseInt(args[0]);
			int bInt = Integer.parseInt(args[1]);
			int c = aInt / bInt;
			
			System.out.println("[result: " + c + "]");
		} catch (IndexOutOfBoundsException | NumberFormatException 
				| ArithmeticException ie){
			System.out.println("test I/N/A");
			/* 捕获多种类型的异常时， 异常变量ie 有因此的final 修饰， 不能重新赋值 */
//			ie = new ArithmeticException("test ");
		} catch (Exception e) {
			e = new RuntimeException("test ()");
		}
	}
}

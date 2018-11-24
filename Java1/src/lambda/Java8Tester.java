package lambda;

public class Java8Tester {
	public static void main(String [] args) {
		Java8Tester tester = new Java8Tester();
		
		MathOperation addition = (int a, int b) -> a + b;
		MathOperation subtraction = (a, b) -> a - b;
		
		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		
		GreetingService greetOne = (s) -> System.out.println("Hello!" + s);
		
		greetOne.sayMsg("Google");
	}
	
	private int operate(int a, int b, MathOperation mathoperation) {
		return mathoperation.operation(a, b);
	}

	@FunctionalInterface
	interface MathOperation{
		int operation(int a, int b);
	}
	
	@FunctionalInterface
	interface GreetingService{
		void sayMsg(String msg);
		default void sayMsg(String s1, String s2) {
			System.out.println(s1 + s2);
		}
	}
}

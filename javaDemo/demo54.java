
public class demo54 {
	public static void main(String[] args) {
		new demo54().test();
	}
	
	public void test() {
		double a = 3, b = 4;
		Operation plusOperation = Operation.valueOf(Operation.class, "PLUS");
		double result = plusOperation.eval(a, b);
		System.out.println("plus a and b ---- [" + result + "]");
		System.out.println("minus----[" + Operation.MINUS.eval(a, b) + "]");
	}
}

enum Operation{
	PLUS{
		@Override
		double eval(double a, double b) {
			return a + b;
		}
	},
	MINUS{
		@Override
		double eval(double a, double b) {
			return a - b;
		}
	},
	TIMES{
		@Override
		double eval(double a, double b) {
			return a * b;
		}
	},
	DIVIDE{
		@Override
		double eval(double a, double b) {
			return a / b;
		}
	};
	
	abstract double eval(double a, double b);
}

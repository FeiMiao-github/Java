import java.math.BigDecimal;

public class demo67 {
	public static void main(String[] args) {
		demo67 demo = new demo67();
		demo.test();
	}
	
	public void test() {
		// 使用常见的double类型和float类型计算
		System.out.println("0.01 + 0.05 等于" + (0.01 + 0.05));
		// = 0.060000000000000005
		System.out.println("1 - 0.42 等于" + (1 - 0.42));
		// = 0.5800000000000001
		System.out.println("4.015 * 100 等于" + (4.015 * 100));
		// = 401.49999999999994
		System.out.println("123.3 / 100 等于" + (123.3 / 100));
		System.out.println("0.1(float) 等于" + 0.01f);
		
		for(double i = 0.01; i < 0.1; i = i + 0.01) {
			System.out.println("[double]" + (i + 0.05));
		}
		
		BigDecimal decimal_dot05 = new BigDecimal("0.05");
		BigDecimal decimal_dot01 = new BigDecimal("0.01");
		for (int i = 1; i < 10; i++) {
			System.out.println("[BigDecimal]" + new BigDecimal(i).multiply(decimal_dot01).add(decimal_dot05));
		}

		// 如果一定要使用 double 构造 BigDecimal 对象， 使用 valueOf
		BigDecimal ret = this.add(0.01, 0.05);
		System.out.println("[this.add]" + ret.toString());
	}

	public BigDecimal add(double a, double b) {
		BigDecimal bd1 = BigDecimal.valueOf(a);
		BigDecimal bd2 = BigDecimal.valueOf(b);

		return bd1.add(bd2);
	}
}
public class demo65 {
	public static void main(String[] args) {
		new demo65().test();
	}
	
	public void test() {
		new MathTest() {
			
			@Override
			public void mathTest() {
				// ����ת��Ϊ�Ƕȣ� �Ƕ�ת��Ϊ����
				System.out.println("Math.toDegrees(1.57) --- "+ Math.toDegrees(1.5707964));
				System.out.println("Math.toRadians(90) --- " + Math.toRadians(90));
				
				// ���㷴����
				System.out.println("Math.acos(Math.PI) --- " + Math.acos(Math.PI));
			}
		}.mathTest();
	}
}

interface MathTest {
	public void mathTest();
}
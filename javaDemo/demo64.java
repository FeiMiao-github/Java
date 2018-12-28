public class demo64 {

	public static void main(String[] args) {
		new demo64().test();
	}
	
	public void test() {
		StringBufferTest stringBufferTest  = ( ) -> {
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("Java");
			stringBuffer.insert(0, "hello ");
			stringBuffer.replace(5, 6, ",");
			stringBuffer.delete(5, 6);
			stringBuffer.reverse();
			
			System.out.print(stringBuffer);
		};
		
		stringBufferTest.test();
	}
}

interface StringBufferTest {
	public void test();
}
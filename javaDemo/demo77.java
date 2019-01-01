import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*  实现文件的复制功能 */
public class demo77 {
	public static void main(String[] args) throws Throwable{
		demo77 demo = new demo77();
		switch (0) {
		case 0:
			demo.test0();
			break;
		case 1:
			demo.test1();
			break;
		default:
			break;
		}
	}
	
	public void test0() throws IOException {
		byte[] cbuf = new byte[32];
		FileInputStream fInputStream = null;
		FileOutputStream fOutputStream = null;
		int hasRead = 0, total = 0;
		
		try {
			fInputStream = new FileInputStream(".\\src\\demo77.java");
			fOutputStream = new FileOutputStream(".\\text.txt");
			System.out.println("[remain bytes can be read]" + fInputStream.available() + "bytes");
			
			while ((hasRead = fInputStream.read(cbuf)) > 0) {
				fOutputStream.write(cbuf, 0, hasRead);
				total += hasRead;
			}
		}  finally {
			fInputStream.close();
			fOutputStream.close();
		}
		
		System.out.println("[Total]" + total + "bytes");
	}
	
	public void test1() throws IOException {
		byte[] cbuf = new byte[32];
		FileInputStream fInputStream = null;
		int hasRead = 0, total = 0;
		
		fInputStream = new FileInputStream(".\\test.mp3");
		while ((hasRead = fInputStream.read(cbuf)) > 0) {
//			System.out.println(sTransBinary(cbuf));
//			System.out.println("point");
			System.out.println(Arrays.toString(cbuf));
		}
		
		fInputStream.close();
		System.out.println("[Total]" + total + "bytes");
	}
	
	public String sTransBinary(byte[] bArray) {
		StringBuilder s = new StringBuilder();
		final String[] zero = new String[] {
			"0", "00", "000", "0000", "00000", "000000", "0000000"
		};
		int temp = 0;
		for (byte b: bArray) {
			temp = (int)b & 0xFF;
			s = new StringBuilder(Integer.toBinaryString(temp));
			
			if (s.length() < 8) {
				s.insert(0, zero[7 - s.length()]);
			}
			System.out.println(s);
		}
		return null;
	}
	
}
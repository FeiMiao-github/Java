import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.Test;
//import java.util.Arrays;

public class demo80 {
	public static void main(String[] args) throws Throwable {
		new demo80().test1();
	}
	
	public void test1() throws IOException {
		byte[] cbuf = new byte[16];
		FileInputStream fInputStream = null;
		FileWriter fWriter = null;
		
		int hasRead = 0, total = 0;
		
		fInputStream = new FileInputStream(".\\test.mp3");
		fWriter = new FileWriter("mp3.txt");
		PrintWriter pWriter = new PrintWriter(fWriter);

		while ((hasRead = fInputStream.read(cbuf)) > 0) {
//			System.out.println(sTransBinary(cbuf));
//			System.out.println("point");
//			System.out.println(Arrays.toString(cbuf));
			System.out.println("[hasRead]" + hasRead + "bytes");
			pWriter.write(sTransBinary(cbuf) + "\r\n");
			total += hasRead;
		}
		
		fInputStream.close();
		fWriter.close();
		pWriter.close();
		System.out.println("[Total]" + total + "bytes");
	}
	
	@Test
	public void test() {
		byte[] n = {1, 0, 127, -128};
		System.out.print(sTransBinary(n));
	}
	
	public String sTransBinary(byte[] bArray) {
		StringBuilder s = new StringBuilder();
		StringBuilder ret = new StringBuilder();
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
			ret.append(s);
			ret.append(' ');
//			System.out.println(s);
		}
		return new String(ret);
	}
}

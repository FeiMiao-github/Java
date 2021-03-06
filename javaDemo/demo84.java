import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class demo84 {
	public static void main(String[] args) {
		demo84 demo = new demo84();
		
//		demo.test();
		demo.testInput();
	}
	
	public void test() {
		/*  重定向标准输出流 */
		try (
				PrintStream printStream = new PrintStream(new FileOutputStream("toast.txt"))) {
			try {
				System.setOut(printStream);
				System.out.println("12345");
				System.out.println("12345");
				System.out.println("12345");
				System.out.println("12345");
				System.out.println("12345");
				System.out.println(new demo84());
			} finally {
				printStream.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testInput() {
		/*重定向输入*/
		System.out.println("input start");
		try(FileInputStream fis = new FileInputStream("F:\\github\\project\\demo\\toast.txt")){
			try {
				System.setIn(fis);
				
				Scanner n = new Scanner(System.in);
				while (n.hasNext()) {
					System.out.println("[output]" + n.next());
				}
			} finally {
				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

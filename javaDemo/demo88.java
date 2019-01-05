import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Scanner;

public class demo88 {
	/*重定向标准输入输出*/
	public static void main(String[] args) {
		new demo88().test3();
	}
	
	/*虚拟机读写其它进程的数据*/
	public void test3() {

		try {
			Process p = Runtime.getRuntime().exec("g++ --help");
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String buf = null;
			
			while ((buf = in.readLine()) != null) {
				System.out.println("[Error]" + buf);
			}
			
			System.out.println("[123]");
			BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			bfw.write("我从未见过如此厚颜无耻之人！");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void test2() {
		try (FileInputStream fis = new FileInputStream("out.txt")) {
			System.setIn(fis);
			
			Scanner sc = new Scanner(System.in);
			while (sc.hasNextLine()) {
				System.out.println("[InputStream]" + sc.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void test1() {
		try (PrintStream ps = new PrintStream(new FileOutputStream("out.txt"))){
			System.setOut(ps);
			System.out.println("巴扎嘿！");
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

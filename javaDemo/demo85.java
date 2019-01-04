import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 读取Javac进程的数据  */
public class demo85 {
	public static void main(String[] args) {
		demo85 demo = new demo85();
		demo.test();
	}
	
	public void test() {
		ProcessBuilder javac = new ProcessBuilder("javac");
		try {
			Process ps = javac.start();
			BufferedReader bf = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			
			String s = null;
			while ((s = bf.readLine()) != null) {
				System.out.println("[Output]" + s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class demo82 {
	public static void main(String[] args) {
		new demo82().test();
	}
	
	public void test() {
		String s = null;
		System.out.println("入力を開始");
		try(
				InputStreamReader inputStreamReader = new InputStreamReader(System.in);
				BufferedReader bufReader = new BufferedReader(inputStreamReader)){
			try {
				while ((s = bufReader.readLine()) != null) {
					if (s.equals("exit") || s.equals("quit")) {
						System.exit(0);
					}
					System.out.println("[ReadLine]" + s);
				}
			} finally {
				inputStreamReader.close();
				bufReader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

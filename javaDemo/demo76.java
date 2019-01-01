import java.io.FileReader;
import java.io.IOException;

/* Reader类*/
public class demo76 {
	public static char[] cbuf = new char[32];
	public static void main(String[] args) throws Throwable{
		new demo76().test();
	}
	
	public void test() throws IOException{
		FileReader fReader = null;
		try {
			fReader = new FileReader("F:\\github\\project\\demo\\src\\demo76.java");
			int hasRead = 0;
			while ((hasRead = fReader.read(cbuf)) > 0) {
//				System.out.println("hasRead" + hasRead);
				System.out.print(new String(cbuf, 0, hasRead));
			}
		} finally {
			fReader.close();
		}
	}
}
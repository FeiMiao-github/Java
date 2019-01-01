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

			System.out.println();
			System.out.println("[MarkSupported]" + fReader.markSupported());
		} finally {
			fReader.close();
		}
	}
}
/*编码格式 UTF-8
* 若使用其他格式可能会出现 NullPointerException */
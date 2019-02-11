package throwable;

import java.io.FileInputStream;
import java.io.IOException;

/* 访问异常信息 */
public class demo139 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("a.txt");
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}
}

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class demo75 {
	private static byte[] cBuffer = new byte[1024];
	/* 使用FileStream 读取自身*/
	public static void main(String[] args) throws IOException {
		new demo75().test();
	}
	
	public void test() throws IOException {
		
		File f = new File("demo75.java");
		System.out.println(f.getAbsolutePath());
		/* 此处返回的路径是 F:\github\project\demo\test.java
		* 实际文件加路径应该是 F:\github\project\demo\src\test.java
		* FileInputStream fis = new FileInputStream(f)
		* 所以可能会出现 FIleNotFoundException 的异常*/
		
		FileInputStream fis = new FileInputStream("F:\\github\\project\\demo\\src\\demo75.java");
		System.out.println("[CanbeRead]" + fis.available() + "bytes");
		
		int hasRead = 0;
		try {
			while ((hasRead = fis.read(cBuffer)) > 0) {
				System.out.println("[hasRead]" + hasRead + "bytes");
				System.out.println("[cBuffer]" + new String(cBuffer, 0, hasRead));
//				for (byte b : cBuffer) {
//					System.out.print(b);
//				}
			}
		} finally {
			fis.close();
		/*  程序中打开的IO资源不属于内存资源， 垃圾回收机制无法回收，需要手动回收  */
		}
	}
}
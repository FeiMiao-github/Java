package throwable;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/* 异常处理的嵌套 */
public class demo141 {
	/* 实现了Closeable接口 或者 AutoCloseable 接口的， 可以使用下面这种代码自动关闭资源 */
	public static void main(String[] args) {
		try (BufferedReader bf = new BufferedReader(new FileReader("demo141.java")); 
				PrintStream ps = new PrintStream(new FileOutputStream("a.txt"))) {
			System.out.println(bf.readLine());
			ps.println("123");
		} catch (IOException e) {
			System.out.println("IO Exception");
		}
	}
}

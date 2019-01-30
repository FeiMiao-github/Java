package Map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @author JZ 使用 Properties 读写属性文件 把 属性文件中的 key-value 对读进 Map 对象中
 */
public class demo119 {
	public static void main(String[] args) throws Exception {
		demo119 demo = new demo119();

		demo.test();
	}

	@SuppressWarnings("deprecation")
	void test() throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\Map\\demo119.properties");
		
		prop.load(fis);// Stream
		
		prop.forEach((o1, o2) -> print((String) o1 + "----" +(String)o2));
		prop.setProperty("4", "end");
		
		prop.save(new FileOutputStream(".\\src\\Map\\demo119.properties"), "追加");
	}

	void printStream(FileInputStream fis) throws Exception {
		byte[] buff = new byte[1024];
		int hasRead = 0;
		while ((hasRead = fis.read(buff)) > 0) {
			String s = new String(buff, 0, hasRead);
			print(s);
		}
	}
	
	void print(Object...o) {
		if (o.length < 1) return;
		
		if (o.length > 1) {
			System.out.println("--------------------start----------------------");
			if (o.length > 0)
				for (var ele: o)
					System.out.println(ele);
			System.out.println("----------------------end----------------------");	
		} else if (o.length == 1) {
			System.out.println(o[0]);
		}
	}
}

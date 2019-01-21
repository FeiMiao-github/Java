package I18N;

import java.text.MessageFormat;
import java.util.Date;
import java.util.ResourceBundle;

/* 使用类文件替代资源文件， 将所有的key-value存入class文件而不是 */
public class demo95 {
	public static void main(String[] args) {
		demo95 demo = new demo95();
		
		demo.test();
	}
	
	void test() {
		ResourceBundle rb = ResourceBundle.getBundle("I18N.Mess");
		String msg = rb.getString("msg");
		String prt = MessageFormat.format(msg, "Yu", new Date());
		
		System.out.println(prt);
	}
}

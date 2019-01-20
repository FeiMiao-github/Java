package I18N;

import java.util.Locale;
import java.util.ResourceBundle;

/* 完成程序国际化 */
public class demo93 {
	public static void main(String[] args) {
		new demo93().test();
	}
	
	void test() {
		Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
		ResourceBundle r = ResourceBundle.getBundle("I18N.mess", myLocale);
		 /* 包名.文件名, 无后缀， utf-8 */
		
		System.out.println(r.getString("hello"));
	}
}


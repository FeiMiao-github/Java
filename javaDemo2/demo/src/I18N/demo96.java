package I18N;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/* 使用 NumberFormat 格式化数字*/
public class demo96 {
	static final Double DB = 123456789.5678;
	static final Locale[] LOCALES = {
			Locale.CHINA,
			Locale.JAPAN,
			Locale.GERMANY,
			Locale.US,
	};
	
	public static void main(String[] args) {
		demo96 demo = new demo96();
		
		demo.test();
	}
	
	/* 获取 NumberFormat */
	void test() {
		NumberFormat l = null;
		String res = null;
		for (Locale locale: LOCALES) {
			print(locale.getDisplayName());
			l = NumberFormat.getCurrencyInstance(locale);
			/* double转化为货币格式的字符串 */
			res = l.format(DB);
			
			print(res);
			
			/* 货币字符串转化为数字 */
			try {
				System.out.println(l.parse(res));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		/* 整数格式 */
		l = NumberFormat.getIntegerInstance();
		res = l.format(DB);
		print(res);
		
		
		/* 数字格式 */
		l = NumberFormat.getNumberInstance();
		res = l.format(DB);
		
		print(res);
		
		double d = 0.34567;
		l = NumberFormat.getPercentInstance();
		res = l.format(d);
		
		print(res);
	}
	
	public void print(Object o) {
		
		if(o == null) return;
		
		if (o instanceof Number || o instanceof String) {
			System.out.println(o.toString());
		}
	}
}

package I18N;
/* 使用DateFormat格式化日期、时间  */

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class demo97 {

	public static void main(String[] args) {
		demo97 demo = new demo97();
		
		demo.test1();
	}
	
	void test() {
		Date date = new Date();
		DateFormat[] df = new DateFormat[16];
		
		Locale[] locale = {
				Locale.CHINA, Locale.US
		};
		
		for (var i = 0; i < locale.length; i++) {
			for (var j= 0; j < 4; j++) {
				df[i*8 + j] = DateFormat.getTimeInstance(j, locale[i]);
				df[i*8 + j + 4] = DateFormat.getDateInstance(j, locale[i]);
			}
		}
		
		for (var i = 0; i < locale.length; i++) {
			for (var j= 0; j < 4; j++) {
				String res = df[i*8 + j].format(date) + " || " + df[i*8 + j + 4].format(date);
				System.out.println(res);
			}
		}
	}
	
	void test1() {
		DateFormat df = DateFormat.getDateInstance();
		String str1 = "2019/1/20";
		String str2 = "2019年1月20日";
		
		try {
			System.out.println(df.parse(str2));
			/* 必须用 DateFormat.SHORT 解析 */
			System.out.println(DateFormat.getDateInstance(DateFormat.SHORT).parse(str1));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

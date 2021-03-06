package I18N;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/*
 * 使用MessageFormat 处理包含占位符的字符串 
 * */
public class demo94 {
	public static void main(String[] args) {
		Locale myLocale = null;
		
		if (args.length == 2) {
			myLocale = new Locale(args[0], args[1]);
		} else {
			myLocale = Locale.getDefault();
		}
		
		ResourceBundle rb = ResourceBundle.getBundle("I18N.myMess", myLocale);
		/* 取得已经加载的语言资源文件中 msg 对应消息 */
		String msg = rb.getString("msg");
		/* 使用 MessageFormat.format为带占位符的字符串传入消息 */
		String prt = MessageFormat.format(msg, "yeeku", new Date());
		System.out.println(prt);
	}
}

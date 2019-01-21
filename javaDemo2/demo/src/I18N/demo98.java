package I18N;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**/
public class demo98 {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("Gyyyy年的第D天");
		// 将Date 格式化为公元2019年第123天
		
		String dateStr = sdf1.format(date);
		System.out.println(dateStr);
		
		String str = "19###三月##21";
		SimpleDateFormat sdf2 = new SimpleDateFormat("y###MMM##d");
		date = sdf2.parse(str);
		System.out.println(date.toString());
	}
}

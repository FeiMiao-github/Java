package testData;

import java.util.regex.Pattern;

public class RegexString {
	private Pattern p;
	private int num = -1;
	
	public String getTestString(int index) {
		return this.testString[index];
	}
	
	public String getRegexString(int index) {
		return this.regexString[index];
	}
	
	public Pattern getPattern(int index) {
		/* TODO: */
		if (index != num) {
			this.p = Pattern.compile(regexString[index]);
		}
		
		return p;
	}
	
	// 正则化表达式字符串匹配测试类
	private String[] testString = {
			/* 0 */ "123abc456def789ghi",
			
			/* 1 regexString: 2*/
			"卖书买书，联系13122111122\r\n"
			+ "交朋友，联系13123145123\r\n"
			+ "打麻将，联系13123133323\r\n",
			
			/*2 regexString: 3*/
			"kongyeeku2@w163.com\r\n"
			+ "kongyeeku@gmail.com\r\n"
			+ "ligang@crazyit.org\r\n"
			+ "wawa@abc.xx\r\n",
			
			/* 3 */
			"We’re getting Don Johnson vibes from this image of Miami’s iconic \r\n"
			+ "Ocean Drive. It’s a landmark that’s appeared in many TV shows and \r\n"
			+ "movies over the years while also being home to celebrities like Gianni \r\n"
			+ "Versace. This weekend the city is celebrating the neighborhood’s \r\n"
			+ "distinct architecture. Art Deco Weekend is a long-running, \r\n"
			+ "free community festival that shines a light on the unique architecture \r\n"
			+ "here on Ocean Drive and throughout the Miami Art Deco District. \r\n"
			+ "Art Deco, which reached its peak in the 1920s in the United States, \r\n"
			+ "is known for streamlined designs and symmetrical geometric figures, \r\n"
			+ "a look that pairs nicely with Miami’s ocean views.",
		};

	private String[] regexString = {
			/* 0 */
			"^(123\\S*){1}$",
			
			/* 1 */
			"((\\d){3})",
			
			/* 2 匹配“13”，“14”， “15”， “17”， “18” 开头11位数字*/
			"((13\\d)|(14\\d)|(15\\d)|(17\\d)|(18\\d))\\d{8}",
			
			/* 3 匹配邮箱 */
			"\\w{3,20}@\\w+\\.(com|org|cn|net|gov)",
			
			/* 4 */
	};
}

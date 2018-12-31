import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * demo70 正则表达式
 *  */
public class demo70 {
	public static void main(String[] args) {
		demo70 demo = new demo70();
		
		switch (0) {
		default:
			return;
		case 0:
			demo.testPM();
			break;
		case 1:
			demo.test();
			break;
		}
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	
	public void test() {
		String str1 = new String("hello, world!");
		String str = str1.replaceFirst("\\w*\\s+", "\u307f\u3055\u304b\u307f\u3053\u3068\\\\");
		prtStr(str);
	}
	
	public void prtStr(Object str) {
		System.out.println(String.valueOf(str));
	}
	
	public void testPM() {
		/* 将一个字符串编译为  Pattern 对象 */
		Pattern p1 = Pattern.compile("a*b");
		/* 利用Pattern对象生成Matcher对象*/
		Matcher m = p1.matcher("123aaaaaaaab123");
		boolean b = m.matches();
		prtStr("[testPattern, Matcher]" + b);
		
		// 上面的语句的简单书写格式
		Object o = Pattern.matches("a\\w*b", "aaaaaaaaaaaaaaaa123b");
		prtStr("[testPM_1]" + o);
		
		/* 返回目标字符串中是否包含有 */
		/* Attempts to find the next subsequence 
		 * of the input sequence that matches the pattern. 
		 * */
		if (m.find()) {
			prtStr("[testPM_2]" + m.group());
		}
		
		m.reset("aaabbb 1234");
		prtStr("[testPm_3]" + m.pattern());
		prtStr("[testPm_3]" + m.lookingAt());
	}
}


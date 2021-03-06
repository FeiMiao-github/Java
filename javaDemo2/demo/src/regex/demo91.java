package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import testData.RegexString;

public class demo91 {
	public static void main(String[] args) {
		demo91 demo = new demo91();
		
		demo.test3();
	}
	
	public void test() {
		/* 正则化表达式要先被编译成 Pattern 对象 */
		Pattern p = Pattern.compile("a*b"); 
		/* 创建 Matcher 对象 */
		Matcher m = p.matcher("aaaaab");
		System.out.println(m.matches());
		
		boolean b = Pattern.matches("A.b", "Acb");
		System.out.println("[A.b]" + b);
	}
	
	public void test1() {
		RegexString s = new RegexString();
		String testString = s.getTestString(1);
		Pattern p = s.getPattern(2);
		Matcher m = p.matcher(testString);

		while (m.find()) {
			System.out.println(m.group() + "[start: "+ m.start() + ", end: " + m.end() + "]");
		}
	} 
	
	// lookingAt, matches, reset
	public void test2() {
		RegexString s = new RegexString();
		String  teString = s.getTestString(2);
		String regexString = s.getRegexString(3);
		String[] testStrings = teString.split("\r\n");

		Pattern p = Pattern.compile(regexString);
		Matcher m = null;
		
		for (String mail: testStrings) {
			if (m == null) {
				m = p.matcher(mail);
			} else {
				m.reset(mail);
			}
			
			String res = mail + " is" + (m.matches() ? "" : " not") + " a valid mail address! ";
			System.out.println(res);
		}
	}
	
	// 对字符串进行分割查找和替换
	public void test3() {
		RegexString r = new RegexString();
		
		String testString = r.getTestString(3);
		System.out.println(testString);
		
		Pattern p = Pattern.compile("[A-Z]\\w*");
		Matcher matcher = p.matcher(testString);
		
		System.out.println("-----------------------------------------");
		System.out.println(matcher.replaceAll("[haha]"));
	}
}

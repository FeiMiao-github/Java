package regex;

import java.util.Arrays;

import testData.*;

public class demo90 {
	public static void main(String[] args) {
		RegexString rString = new RegexString();
		
		String regexString = rString.getRegexString(0);
		String testString = rString.getTestString(0);
		// 123abc456def789ghi
		demo90 demo = new demo90(testString);
		System.out.println(demo.testMatch("123\\w*"));
		
		regexString = rString.getRegexString(1);
		System.out.println(demo.testReplaceAll(regexString, "[]"));
		
		System.out.println(demo.testReplaceFirst(regexString, "[change]"));
		
		String[] strings = demo.testSplit(regexString);
		System.out.println(Arrays.toString(strings));
	}
	
	private String args;
	private demo90(String args) {
		this.args = args;
	}
	
	public demo90 valueOf(String args) {
		return new demo90(args);
	}
	
	// 正则化表达式
	// String 类常见的方法
	public boolean testMatch(String regex) {
		// 判断字符串是否匹配指定的表达式
		return this.args.matches(regex);
	}
	
	// 替换所有 匹配 regex 的字符
	public String testReplaceAll(String regex, String replacement) {
		return this.args.replaceAll(regex, replacement);
	}
	
	// 替换第一个匹配 regex 的字符串
	public String testReplaceFirst(String regex, String replacement) {
		return this.args.replaceFirst(regex, replacement);
	}
	
	// 根据 regex 分割字符串
	public String[] testSplit(String regex ) {
		return this.args.split(regex);
	}
}

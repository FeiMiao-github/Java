package testData;

public class RegexString {
	
	public String getTestString(int index) {
		return this.testString[index];
	}
	
	public String getRegexString(int index) {
		return this.regexString[index];
	}
	
	// 正则化表达式字符串匹配测试类
	private String[] testString = {
			"123abc456def789ghi", // 0
			};
	
	private String[] regexString = {
			"^(123\\S*){1}$",
			"((\\d){3})"
	};
}

package netProgram;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* application/x-www-form-urlencoded 编码和解码*/
public class demo170 {
	static String 哈皮 = "你就是一个憨批";
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		// 编码
		String 编码 = URLEncoder.encode(哈皮, "UTF-8"); 
		System.out.println("编码: " + 编码);
		
		// 解码
		String 解码 = URLDecoder.decode(编码, "UTF-8"); 
		System.out.println("解码: " + 解码);
	}
}

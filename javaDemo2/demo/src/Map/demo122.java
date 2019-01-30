package Map;

import java.util.IdentityHashMap;

/**
 * @author JZ
 * identityHashMao 实现类
 * 当且仅当两个key  严格相等时 key1 == key2 时， 才认为两个key相等
 */
public class demo122 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IdentityHashMap<String, String> ihm = new IdentityHashMap<String, String>();
		
		String s1 = "1";
		String s2 = new String(s1);
		
		System.out.println(s1 == s2); // false
		
		ihm.put(s1, "你好");
		ihm.put(s2, "再见");
		
		System.out.println(ihm);
	}
}

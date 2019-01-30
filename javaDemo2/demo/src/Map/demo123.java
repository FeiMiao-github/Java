package Map;

import java.util.EnumMap;

public class demo123 {
	/**
	 * EnumMap 实现类
	 * 必须指定一个枚举类， 将EnumMap和指定枚举类关联起来
	 * 不允许使用null 作为key
	 */
	public static void main(String[] args) {
		EnumMap<Season, String> em = new EnumMap<Season, String>(Season.class);
		
		em.put(Season.SPRING, "春暖花开");
		em.put(Season.SUMMER, "夏日炎炎");
		
		System.out.println(em);
	}
}

enum  Season {
	SPRING, SUMMER, FALL, WINTER
}

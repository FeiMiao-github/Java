package set;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;

/* EnumSet */
public class demo108 {
	public static void main(String[] args) {
		demo108 demo = new demo108();
		
		demo.test2();
		
		demo.test();
	}
	
	/* 创建指定枚举类型EnumSet */
	private void test() {
		/* 创建包含指定枚举类所有枚举值EnumSet */
		EnumSet<Season> ess = EnumSet.allOf(Season.class);
		System.out.println(ess);
		
		/* 创建包含指定枚举类所有枚举值EnumSet */
		EnumSet<Season> ess1 = EnumSet.noneOf(Season.class);
		System.out.println(ess1);
		
		ess1.add(Season.SPRING);
		ess1.add(Season.SUMMER);
		System.out.println(ess1);
		
		/* 创建一个包含多个指定枚举类类型的枚举值的EnumSet */
		EnumSet<Season> ess2 = EnumSet.of(Season.FALL, Season.WINTER);
		System.out.println(ess2);
		
		/* 创建包含剩余枚举值的EnumSet */
		EnumSet<Season> ess3 = EnumSet.complementOf(ess2);
		System.out.println(ess3);
	}
	
	public void test2() {
		/* 从 Collection 生成 EnumSet */
		Collection<Season> cs = new HashSet<Season>();
		cs.add(Season.SPRING);
		cs.add(Season.FALL);
		
		EnumSet<Season> ess = EnumSet.copyOf(cs);
		System.out.println(ess);
	}
}

enum Season {
	SPRING(1), SUMMER(2), FALL(3), WINTER(4);
	
	private int value;
	Season(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}

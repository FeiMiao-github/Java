package set;

import java.util.TreeSet;
import java.lang.Math;

/* TreeSet 类 */
public class demo106 {
	public static void main(String[] args) {
		Zi.test1();
	}
	
	/* TreeSet的定义 */
	public void test0() {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		ts.add(32);
		ts.add(12);
		ts.add(-2);
		ts.add(10);
		ts.add(-9);
		
		System.out.println(ts);
		System.out.println(ts.first());
		System.out.println(ts.lower(4));
	}
	
}

/* 测试类 */
class Zi implements Comparable<Zi> {
	
	private int count = 0;
	
	public Zi(int num) {
		this.count = num;
	}
	
	/* 自然排序 */
	public static void test1() {
		TreeSet<Zi> tse = new TreeSet<Zi>();
		
		tse.add(new Zi(5));
		tse.add(new Zi(-3));
		tse.add(new Zi(9));
		tse.add(new Zi(-2));
		
		print(tse);
		
		Zi first = tse.first();
		print(first);
		
		first.count = 20;
		print(tse);
		
		print(tse.remove(new Zi(20))); // 删除失败
		print(tse); // TreeSet 无序
		print(tse.remove(new Zi(5)));// 删除失败
		print(tse);
		
		print(tse.remove(new Zi(20)));
		print(tse);
	} /* 如果没有实现compareTo方法， ClassCastException 异常 */
	
	/*如果两个对象使用compareTo 方法比较相等， 新对象将无法添加到TreeSet 集合当中*/
	public int compareTo(Zi o) {	
		return count > o.count ? 1 : 
			count < o.count ? -1 : 0;
	}
	
	@Override
	public boolean equals(Object o) {
		return false;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "@"
				+ this.count;
	}
	
	public static void print(Object o) {
		System.out.println(o.toString());
	}
}

/*  */
class Err implements Comparable<Err>{
	
	private int num = 0;
	
	public Err(int num) {
		this.num = num;
	}
	
	/* 自然排序 */
	public static void test1() {
		TreeSet<Err> tse = new TreeSet<Err>();
		
		tse.add(new Err(4));
		tse.add(new Err(3));
		tse.add(new Err(-3));
		
		System.out.println(tse);
		
		tse.first().num = 5;
//		System.out.println(tse);
		
		System.out.println(tse.remove(new Err(5)));
		System.out.println(tse);
		System.out.println(tse.remove(new Err(3)));
		System.out.println(tse);
	} /* ClassCastException 异常 */
	
	/*如果两个对象使用compareTo 方法比较相等， 新对象将无法添加到TreeSet 集合当中*/
	public int compareTo(Err o) {
		if (this.equals(o)) return 0;
		return -Math.abs(this.num) + o.num;
//		return this.num - o.num;
	}
	
	@Override
	public boolean equals(Object o) {
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.num;	
	}
}
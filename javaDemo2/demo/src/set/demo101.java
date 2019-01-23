package set;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/* 使用 Predicate 操作集合*/
public class demo101 {
	public static void main(String[] args) {
		Collection<String> c = new HashSet<String>();
		
		c.add("西游记");
		c.add("三国演义");
		c.add("水浒传");
		c.add("红楼梦");
		
		demo101 demo = new demo101();
		
		demo.test2(c);
	}
	
	public void test1(Collection<String> c) {
		c.removeIf(obj -> ((String)obj).equals("西游记"));
		System.out.println(c);
	}
	
	public void test2(Collection<String> books) {
		System.out.println(calAll(books, ele -> ele.contains("西游")));
		System.out.println(calAll(books, ele -> ele.length() == 3));
	}
	
	public static int calAll(Collection<String> books, Predicate<String> p) {
		int total = 0;
		for (String s: books) {
			if (p.test(s)) {
				total++;
			}
		}
		return total;
	}
}

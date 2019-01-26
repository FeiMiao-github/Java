package List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class demo110 {
	private List<?> lt;
	
	public static void main(String[] args) {
		demo110 demo = new demo110();
		
		demo.test();
	}
	
	@SuppressWarnings("unchecked")
	public void test() {
		lt = new ArrayList<LTest>();
		
		addEle((List<LTest>) lt);
		
		print(lt);
		
		/* 迭代器 */
		ListIterator<LTest> lit = (ListIterator<LTest>) lt.listIterator();
		
		/* 向后迭代 */
		while (lit.hasNext()) {
			LTest temp = lit.next();
			print(temp + "(" + lt.indexOf(temp) + ")");
		}
		
		/* 向前迭代 */
		while (lit.hasPrevious()) {
			LTest temp = lit.previous();
			print(temp + "(" + lt.indexOf(temp) + ")");
		}
	}
	
	public static void addEle(List<LTest> l) {
		for (var i = 0; i < 10; i++) {
			l.add(new LTest(i));
		}
	}
	
	public static void print(Object o) {
		System.out.println(o.toString());
	}
}

class LTest {
	private int num;
	
	public LTest() {};
	public LTest(int n) {
		this.num = n;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "@" 
				+ this.num;
	}
}

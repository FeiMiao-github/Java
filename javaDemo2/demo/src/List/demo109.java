package List;

import java.util.ArrayList;
import java.util.List;

/* 
 * List集合
 * */
public class demo109 {
	public static void main(String[] args) {
		ListTest.test2();
	}
}

class ListTest {
	public void test() {
		List<String> lt = new ArrayList<String>();
		
		lt.add("红楼梦");
		lt.add("三国演义");
		lt.add("水浒传");
		
		lt.add(1, "西游记");
		print(lt);
		
		print(lt.get(0));
		
		lt.remove(3);
		print(lt);
		
		print(lt.indexOf("水浒传"));
		print(lt.indexOf("西游记"));
		
		lt.sort((o1, o2) -> o2.length() - o1.length());
		print(lt);
		
		lt.add("三国演义");
		print(lt);
		
		print(lt.lastIndexOf("三国演义"));
		print(lt.indexOf("三国演义"));
		
		lt.set(0, "西游记");
		print(lt);
		
	}
	
	public static void test2() {
		List<ListTest> l = new ArrayList<ListTest>();
		
		ListTest lt = new ListTest(0);
		
		l.add(lt);
		l.add(lt);
		l.add(lt);
		
		print(l);
		
		l.remove(lt);
		print(l);
	}
	
	public ListTest(int num) {
		this.count = num;
	}
	
	public ListTest() {};
	
	public static void print(Object o) {
		System.out.println(o.toString());
	}
	
	private int count;
	
	@Override
	public boolean equals(Object o) {
		return true;	
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "@"
				+ this.count;
	}
}

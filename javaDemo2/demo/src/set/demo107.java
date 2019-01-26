package set;

import java.util.TreeSet;

/* TreeSet 定制排序 */
public class demo107 {
	public static void main(String[] args) {
		demo107 demo = new demo107();
		demo.test();
	}
	
	public void test() {
		TreeSet<Integer> tsn = new TreeSet<Integer>((o1, o2) -> {
			return o1.intValue() < o2.intValue() ? 1 :
				o1.intValue() > o2.intValue() ? -1 : 0;
		});
		
		tsn.add(3);
		tsn.add(-3);
		tsn.add(9);
		
		System.out.println(tsn);
	}
	
}


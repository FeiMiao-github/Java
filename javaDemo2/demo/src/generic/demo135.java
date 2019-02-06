package generic;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* 设定通配符下限  关键字super */
public class demo135 {
	static List<Integer> intList = new LinkedList<Integer>();
	static List<Number> numList = new LinkedList<Number>();
	
	static {
		intList.add(1);
		intList.add(2);
	}
	
	public static void main(String[] args) {
		System.out.println(intList);
		Integer i = demo135.copy(numList, intList);
		System.out.println("[numList]" + numList
				+ "(i = " + i + ")");
		System.out.println("[i.Class = " + i.getClass().getSimpleName() + "]");
	}
	
	public static <T> T copy(Collection<? super T> cs, Collection<T> cc) {
		T last = null;
		
		for (var e: cc) {
			cs.add(e);
			last = e;
		}
		
		return last;
	}
}

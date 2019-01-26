package Queue;

import java.util.LinkedList;

/* LinkedList
 * 	可用作栈，双端队列， 集合	 */
public class demo114 {
	public static void main(String[] args) {
		demo114 demo = new demo114();
		
		demo.test2();
	}
	
	/* 作为栈使用 */
	public void test1() {
		LinkedList<Integer> ls = getllist();
		
		ls.push(9);
		print(ls);
		
		ls.pop();
		print(ls);
		/* 后入先出 */
	}
	
	public void test2() {
		LinkedList<Integer> lq = getllist();
		
		lq.offer(5);
		print(lq);
		
		lq.poll();
		print(lq);
		/* 后入后出· */
	}
	
	LinkedList<Integer> getllist() {
		LinkedList<Integer> lli = new LinkedList<Integer>();
		
		lli.add(3);
		lli.add(4);
		lli.add(-1);
		lli.add(-9);
		print(lli);
		return lli;
	}
	
	static void print(Object o) {
		System.out.println(o.toString());
	}
}

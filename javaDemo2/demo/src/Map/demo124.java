package Map;

import java.util.ArrayList;
import java.util.Collections;

/* 操作集合的工具类 */
public class demo124 {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		al.add(-1);
		al.add(33);
		al.add(-9);
		al.add(7);
		
		System.out.println(al);
		
		Collections.reverse(al);
		System.out.println("reverse: " + al);
		
		/* 随机排序 */
		Collections.shuffle(al);
		System.out.println("shuffle: " + al);
		
		/* 按自然顺序排序 */
		Collections.sort(al);
	}
}

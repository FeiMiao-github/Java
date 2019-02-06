package Map;

import java.util.Enumeration;
import java.util.Vector;

/* Enumeration 繁琐的接口 */
public class demo129 {
	public static void main(String[] args) {
		/* 加入任何规则都必须慎之又慎， 因为以后无法删除它们 	*/
		Vector<Integer> v = new Vector<Integer>();
		
		v.add(3);
		v.add(6);
		v.add(4);
		
		System.out.println(v);
		
		/* 类似于迭代器 */
		Enumeration<Integer> em = v.elements();
		while (em.hasMoreElements()) {
			System.out.println(em.nextElement());
		}
	}
}

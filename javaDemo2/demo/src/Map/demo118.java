package Map;

import java.util.LinkedHashMap;

/**
 * @author JZ
 *	LinkedHashMap 类
 *	使用双向链表维护Map的迭代顺序
 *	性能略低于HashMap
 */
public class demo118 {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> lm = new LinkedHashMap<Integer, String>();
		
		lm.put(233, "Chinese");
		lm.put(466,  "English");
		lm.put(699, "Math");
		
		// iterate the map
		lm.forEach((k, v)-> System.out.println(v + "-->" + k));
	}
}

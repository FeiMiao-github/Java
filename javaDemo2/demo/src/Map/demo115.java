package Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class demo115 {
	public static void main(String[] args) {
		demo115 demo = new demo115();
		
		demo.test1();
	}
	
	public void test1() {
		Map<Integer, String> map = getMap();
		
		/* 遍历map */
		for (var e: map.keySet()) {
			System.out.println(e + "-->" + map.get(e));
		}
		
	}
	
	
	public void test0() {
		Map<Integer, String> map = getMap();
		
		/* 元素和元素可以重复 */
		map.put(4, "Android");
		print(map);
		
		/* key-value 不可以重复 */
		map.put(4, "iOS");
		print(map);
		
		/*key-value 对组成的集合*/
		Collection<Entry<Integer, String>> mapSet = map.entrySet();
		print("[mapSet]" + mapSet);
		/* 删除key-value 对 */
		map.clear();
		print(map);
		
		print("is map empty? " + map.isEmpty());
	}
	
	public Map<Integer, String> getMap() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(3, "IOS");
		map.put(9, "Windows");
		map.put(6, "Android");
		
		print(map); // 排序
		return map;
	}
	
	static void print(Object o) {
		System.out.println(o);
	}
}

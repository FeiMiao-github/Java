package Map;

import java.util.HashMap;
import java.util.Map;

public class demo116 {
	public static void main(String[] args) {
		demo116 demo = new demo116();

		demo.test();
	}

	void test() {
		  /* remap function */
		Map<Integer, String> map = getMap();
		
		map.put(7, "格格不入");
		print(map);
		
		map.compute(7, (k, v) -> null);
		print(map);
		
		map.compute(7, (k, v)-> "格格不入");
		print(map);
		
		map.forEach((i, s)->System.out.print("[" + i + "--" + s + "]"));
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

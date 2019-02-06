package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Java7 泛型的菱形语法 */
public class demo130 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(); /* 构造器中不需要带完整的泛型信息	 */
		list.add("string1");
		list.add("string2");
		
		list.forEach((o) -> System.out.println(o));
		Map<String, List<String>> map = new HashMap<>();
		map.put("1", list);
		
		map.forEach((k, v) -> System.out.println("[key = " + k +  ", value = " + v + "]\n"));
	}
}

package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* 设置不可变集合 */
public class demo128 {
	public static void main(String[] args) {
		/* 返回不可变的集合， 参数是原有集合， 返回值是该集合的只读版本 	*/
		
		/* 返回一个空的不可变的集合对象 */
		@SuppressWarnings("unused")
		List<?> unmodifiableList = Collections.emptyList();
		
		/* 	创建只有一个元素， 不可变的集合对象 	*/
		/*	此处集合既可以是List， 也可以是Map	*/
		Set<?> unmodifiableSet = Collections.singleton("疯狂java讲义");
		System.out.println(unmodifiableSet);
		
		/* create a Map object */
		Map<String, Integer> map = new HashMap<String, Integer>();
		/* add key-value */
		map.put("Chinese", 22);
		map.put("Math", 88);
		
		Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
		System.out.println(unmodifiableMap);

		/*java.lang.UnsupportedOperationException*/
//		unmodifiableMap.put("English", 33); 
	}
}

package Map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author JZ
 * 	同步控制
 */
public class demo127 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/* 创建线程安全的集合对象 */
		Collection<?> c = Collections.synchronizedCollection(new ArrayList<Integer>());
		List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
		Set<Integer> s = Collections.synchronizedSet(new HashSet<Integer>());
		Map<?, ?> map = Collections.synchronizedMap(new HashMap<Integer, Integer>());
	}
}

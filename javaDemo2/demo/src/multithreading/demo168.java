package multithreading;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/* 包装线程不安全的集合 */
public class demo168 {
	public static void main(String[] args) {
		Collection<Integer> intColl = new HashSet<>();
		
		@SuppressWarnings("unused")
		Collection<Integer> synchronizedCollection = Collections.synchronizedCollection(intColl);  
	}
}

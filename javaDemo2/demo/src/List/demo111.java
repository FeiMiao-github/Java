package List;

import java.util.Arrays;
import java.util.List;

/* ArrayList 和  Vector */
public class demo111 {
	/* 对于通常的编程场景 程序员无需关心 initialCapacity
	 * 	对于先Vector 和 ArrayList 添加大量元素， 可使用ensureCapacity 
	 * 	方法一次性增加initialCapacity， 减少重分配次数 	*/
	public static void main(String[] args) {
		List<Integer> fixedList = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		fixedList.add(1); // UnsupportedOperationException 
		/* 不支持的操作方法 */
	}
}

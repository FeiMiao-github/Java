package Map;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author JZ
 * 	查找， 替换操作
 */
public class demo126 {
	/* Collection 的简单操作 */
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(7);
		nums.add(5);
		nums.add(3);
		nums.add(5);
		nums.add(8);
		
		System.out.println(nums);
		System.out.println("max: " + Collections.max(nums));
		
		Collections.replaceAll(nums, 2, -2);
		System.out.println("min: " + Collections.min(nums));
		
		/* 排序 */
		Collections.sort(nums);
		System.out.println(nums);
		
		/* 只有对排序后的List集合 才可以使用二分法查询 */
		System.out.println("7's index: " + Collections.binarySearch(nums, 7));
	}
}

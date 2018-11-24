package wrapperMethod;

import java.util.ArrayList;
import java.util.Arrays;

public class wrapperDemo {
	public static void main(String[] args) {
		/* declare an array list of Integer objects*/
		ArrayList<Integer> intList = new ArrayList<>();
		/* an ArrayList<Integer> is less efficient than an
		 * int[] because each value is separately wrapped 
		 * inside an object. */
		
		/* autoboxing */
		intList.add(3);
		intList.add(Integer.valueOf(4));
		System.out.println(intList);
		/* OUTPUT:
		 * [3, 4]
		 * */
		
		/* automatically unboxed */
		/* complier translates list.get(i) to 
		 * list.get(i).intValue() 
		 * */
		int[] n = {intList.get(0), intList.get(1).intValue()};
		System.out.println(Arrays.toString(n));
		
		@SuppressWarnings("deprecation")
		Integer intI = new Integer(3);
		System.out.println(intI.intValue());
		
		intI = 5;
		System.out.println(intI.intValue());
		/* OUTPUT:
		 * 3
		 * 5
		 * */
		intI++;
		System.out.println(intI);
		/* OUTPUT:
		 * 6
		 * */
		
		/* a Java implementation may */
		Integer a = 100; 
		Integer b = 100;
		System.out.println("Q1(==):a = b?\tA: " + (a==b));
		System.out.println("a.hashCode: " + a.hashCode() 
			+ "\tb.hashCode: " + b.hashCode());
		/* OUTPUT:
		 * Q1(==):a = b?	A: true
		 * a.hashCode: 100	b.hashCode: 100
		 * */
		System.out.println("Q2(e):a = b?\tA: " + a.equals(b));
		/* OUTPUT:
		 * Q2(e):a = b?	A: true
		 * */
		a = 1000;
		b = 1000;
		System.out.println("Q3(==):a = b?\tA: " + (a==b));
		/* OUTPUT:
		 * Q3(==):a = b?	A: false
		 * */
		System.out.println("Q4(e):a = b?\tA: " + a.equals(b));
		/* OUTPUT:
		 * Q4(e):a = b?	A: true
		 * */
		int num = 1000;
		
		@SuppressWarnings("deprecation")
		Integer integer1 = new Integer(1000);
		@SuppressWarnings("deprecation")
		Integer integer2 = new Integer(1000);
		@SuppressWarnings("deprecation")
		Integer integer3 = new Integer(100);
		@SuppressWarnings("deprecation")
		Integer integer4 = new Integer(100);
		System.out.println("Q: integer1 == integer2?\t A: " + (integer1 == integer2));
		System.out.println("Q: a == integer1\t A: " + (a == integer1));
		System.out.println("Q: num == integer1\t A: " + (num == integer1));
		System.out.println("Q: integer1 == num\t A: " + (integer1 == num));
		System.out.println("Q: integer3 == integer4?\t A: " + (integer3 == integer4));
		/* OUTPUT:
		 * Q: integer1 == integer2?	 A: false
		 * Q: a == integer1	 A: false
		 * Q: num == integer1	 A: true
		 * Q: integer1 == num	 A: true
		 * Q: integer3 == integer4?	 A: false
		 * */
	}
}

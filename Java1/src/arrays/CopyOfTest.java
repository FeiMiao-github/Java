package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/** This program demonstrate(to show or prove something clearly) the 
 * use of reflection for manipulating arrays
 * */
public class CopyOfTest {
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		a = (int[])goodCopyOf(a, 10);
		System.out.println(Arrays.toString(a));
		
		String []b = {"Tom", "Dick", "Harry"};
		b = (String[])goodCopyOf(b, 10);
		System.out.println(Arrays.toString(b));
		
		System.out.println("The following call will generate an exception:");
		b = (String[]) badCopyOf(b, 10);
	}
	
	public static Object[] badCopyOf(Object[] a, int newLength) {
		Object[] newArray = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
		return newArray;
	}
	
	public static Object goodCopyOf(Object a, int newLength) {
		Class<?> c1 = a.getClass();
		if (!c1.isArray()) return null;
		Class<?> c2 = c1.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(c2, newLength);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
		
		return newArray;
	}
}

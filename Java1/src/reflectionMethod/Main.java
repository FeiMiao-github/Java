package reflectionMethod;

import java.util.Random;
import java.lang.reflect.Array;
import java.util.Arrays;
import companyTest.Employee;

public class Main {


	public static void main(String[] args) {
		char[] character = new char[52];
		
		{
			for (int i = 0; i < 26; i++) {
				character[0 + i] = (char)(i + 65);
				character[26 + i] = (char)(i + 97);
			}
		}
		
		System.out.println("start");
		Employee[] employee = new Employee[100];
		for (int i = 0; i < character.length; i++) {
			if (i % 7 == 0) System.out.println();
		}
		
		for(Employee e : employee) {
			String name = ((char)(65 + new Random().nextInt(26))) + "." 
					+ ((char)(97 + new Random().nextInt(26))) 
					+ ((char)(97 + new Random().nextInt(26))) 
					+ ((char)(97 + new Random().nextInt(26))) 
					+ ((char)(97 + new Random().nextInt(26)));
			e = new Employee(name , 1000 + 1000 * new Random().nextDouble());
			System.out.println(e.toString());
		}
		
		// System.out.println(employee[0].toString());
		/*
		 * 对于上面这一句代码输出结果为：
		 * Exception in thread "main" java.lang.NullPointerException at reflectionMethod.Main.main(Main.java:36)*/
		/* 报错 */
		
		System.out.println("for (;;)");
		for (int i = 0; i < employee.length; i++) {
			String name = ((char)(65 + new Random().nextInt(26))) + "." 
					+ ((char)(97 + new Random().nextInt(26))) 
					+ ((char)(97 + new Random().nextInt(26))) 
					+ ((char)(97 + new Random().nextInt(26))) 
					+ ((char)(97 + new Random().nextInt(26)));
			employee[i] = new Employee(name , 1000 + 1000 * new Random().nextDouble());
		}
		System.out.println(employee[0].toString());
		/* 这句代码输出结果为： 
		 *  class companyTest.Employee---[name: Q.asco, salary: $1329.29] */
		
		/*  */
		System.out.println("employee[0]  type=====" + employee[0].getClass());
		/* 输出结果 employee[0]  type=====class companyTest.Employee */
		System.out.println("employee type=====" + employee.getClass());
		/* 输出结果 employee type=====class [LcompanyTest.Employee; */
		
		/* 多态 */
		Object []employ = new Employee[10];
		System.out.println("employ.getClass()=====" + employ.getClass());
		/* 输出结果： employ.getClass()=====class [LcompanyTest.Employee; */
		/* 其中[xxxx;表示数组 */
		
//		System.out.println("employ component type=====" + employ[0].getClass());
		/* 因为此处employ[0]尚未被初始化 */
		
		System.out.println("employ compontent type=====" + employ.getClass().getComponentType());
		
		employee = Arrays.copyOf(employee, 2 * employee.length);
		System.out.println((employee[101] == null) + " " +employee.length);
		
		/*产生100个Employee对象*/
		Object [] newArray ;
		
		/* how can we write a such geneic method ? It helps that 
		 * an Employee[] can converted to an Object[] arry*/
		
		int array[] = new int[10];
		Class<?> cArray = array.getClass();
		System.out.println(cArray);
		
		newArray = (Employee[])goodCopyOf(employee, 400);
		System.out.println(newArray.length);
		System.out.println(newArray.getClass().getName());
	}
	
	public static Object[] badCopyOf(Object[] a, int newlength) {
		Object[ ] newArray = new Object[newlength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newlength));
		return newArray;
		/* However, there is a problem with actually using the resulting array */
		/*An array of objects cannot be cast to an array of employees(Employee[])*/
		/* The machine would generate a ClassCastException at runtime*/
	}
	 ; 
	public static Object goodCopyOf(Object a, int newLength) {
		/*Note that this copyOf method can be used to grow arrays of any type, 
		 * not just arrays of objects */
		
		/* To make it possible, the parameter of goodCopyOf id declared to be the type Object,
		 * not the array of objects(Object[]). The integer array type int[] can be converted to an
		 * Object, but not to an array of objects*/
		Class<?> c1 = a.getClass();
		if (!c1.isArray()) return null;
		Class<?> componentType = c1.getComponentType();
		int length = Array.getLength(a); 
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
		return newArray;
	}
}

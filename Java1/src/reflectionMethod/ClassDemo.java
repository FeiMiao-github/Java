package reflectionMethod;

import java.util.Random;

import hashCodeDemo.Student;

public class ClassDemo implements InterfaceDemo{
	
	public static final int finalNum = 1;
	
	public static void main(String[] args) {
		Class<ClassDemo> c1 = ClassDemo.class;
		Student stu = new Student("what");
		Class<? extends Student> c2 = stu.getClass();
		ClassDemo c3 = new ClassDemo();

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(ClassDemo.class);
		System.out.println(c3.getClass().toString());

		/* Probably the most commonly used method of Class is getName() */
		/* This returns the name of the class! */

		System.out.println(c3.getClass().getName());
		/* reflectionMethod.ClassDemo 
		 * the package name is part of the class name.*/
		System.out.println(stu.getClass().getName() + "\t" + stu.getName());
		/* print class name */

		/* obtain a Class object corresponding to a class name */
		try {
			Class<?> c = Class.forName("companyTest.Employee");
			System.out.println(c.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		/* supply an exception handler whenever you use forName() method */
		try {
			Class<?> cn = Class.forName("reflectionMethod.InterfaceDemo");
			System.out.println(cn.getName());
		} catch(ClassNotFoundException e) {
			System.out.println("error in " +  e );
		}
		
		System.out.println("class name : " + Random.class.getName());

		/* for historical reasons, the getName() method returns somewhat strange names for array types */
		System.out.println(Double[].class.getName());
		System.out.println(Double.class.getName());
		/* OUTPUT:
		 * [Ljava.lang.Double;
		 * java.lang.Double
		 * */
		System.out.println(int[].class.getName());
		System.out.println(int.class.getName());
		/* OUTPUT:
		 * [I
		 * int
		 * */
		
		/* use the == operator to compare class objects*/
		if (Double.class == double.class) System.out.println("true");
		else System.out.println("false");
		
		/* the newInstance method calls no-argument constructor to initialize the newly created object*/
		/* if the class does not have a no-argument constructor, a exception is thrown */
		String s = "java.util.Random";
		try {
			@SuppressWarnings("deprecation")
			Object m = Class.forName(s).newInstance();
			m = new Random();
			System.out.println(m.getClass().getName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} 
	}
	
	public String getName() {

		return this.getClass().getName();
	}
}

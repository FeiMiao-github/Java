package toStringmethod;

import java.time.LocalDate;
import java.util.Arrays;
import java.awt.Point;

public class Main {

	public static void main(String[] args) {
		Point aPoint = new Point(3, 2);
		
		System.out.println(aPoint.toString());
		/*
		 * OUTPUT:
		 * java.awt.Point[x=3,y=2]
		 * */
		
		LocalDate date = LocalDate.of(1002, 1, 31);
		System.out.println(date.toString());
		/* OUTPUT:
		 * 1002-01-31
		 * */
		
		String str = "Hello";
		System.out.println(str);
		/* OUTPUT:
		 * Hello
		 * */
		
		System.out.println(aPoint.getClass().toString());
		System.out.println(date.getClass().toString());
		System.out.println(str.getClass().toString());
		/* OUTPUT:
		 * class java.awt.Point
		 * class java.time.LocalDate
		 * class java.lang.String
		 * */
		
		Employee e = new Employee("Marry", 234.0);
		Manager m = new Manager("Harry", 345.1);
		m.setBonus(22.9);
		
		System.out.println(e.toString());
		System.out.println(m.toString());
		/* OUTPUT:
		 * class toStringmethod.Employee[name: Marry, salary: $234.0]
		 * class toStringmethod.Manager[name: Harry, salary: $368.0]
		 * */
		
		System.out.println(e);
		/* OUTPUT:
		 * class toStringmethod.Employee[name: Marry, salary: $234.0]
		 * */
		
		Object obj = new Object();
		System.out.println(obj);
		/* OUTPUT:
		 * java.lang.Object@2b80d80f
		 * */
		
		int[] array = {1, 2, 3};
		System.out.println(array);
		/* OUTPUT:
		 * [I@3ab39c39
		 * */
		System.out.println(Arrays.toString(array));
		/* OUTPUT:
		 * [1, 2, 3]
		 * */
		
		System.out.println(e.getClass().getSuperclass());
		System.out.println(m.getClass().getSuperclass());
		/* OUTPUT:
		 * class java.lang.Object
		 * class toStringmethod.Employee
		 * */
	}

}

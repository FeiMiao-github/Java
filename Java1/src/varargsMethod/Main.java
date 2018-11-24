package varargsMethod;

import companyTest.Employee;

public class Main {

	public static void main(String[] args) {
		
		System.out.printf("Her name is %s!\n", "Mary");
		System.out.printf("%s is %d years old!\n", "Mary", 6);
		
		printf(new Employee("Not", 321), new Employee("H", 123));
		
		//printf(e1, e2);
		double []arrayInt = { 1.0, 2.0 , 3.0, 5.0, 6.0, 8.0};
		double maxdouble = max(arrayInt);
		System.out.println(maxdouble);
		System.out.printf("%s--$%.2f", new Object[] {"Haha", 32.4});
	}
	
	/* a method is defined like this: */
	public static void printf(Object...objects) {
		for (Object ele: objects) {
			if (ele.getClass() == Employee.class) {
				System.out.println(ele.toString());
				}
		}
	}
	
	public static double max(double ...value) {
		double largest = Double.NEGATIVE_INFINITY;
		for (double elements: value) {
			if (elements > largest)
				largest = elements;
		}
		
		return largest;
	}
}
package reflectionMethod;

import companyTest.Employee;
import objectAnalyzer.ObjectAnalyzer;
import objectAnalyzer.ObjectAnalyzerBook;
import java.util.ArrayList;

public class reflection2Test {
	public static void main(String[] args) {
		/* You can use this toString method to peek inside any Object*/
		
		Employee e = new Employee("reflection", 1);
		new ObjectAnalyzer().toString(e);
		System.out.println();
		System.out.println(new ObjectAnalyzerBook().toString(e));
		System.out.println();
		
		Class<?> c = int.class;
		System.out.println(c.isPrimitive());
		Class<?> c1 = Integer.class;
		System.out.println(c1.isPrimitive());
		System.out.println();
		Double doublenum = 1.0;
		System.out.println(new ObjectAnalyzerBook().toString(doublenum));
		
		System.out.println();
		System.out.println();
		ArrayList<Integer> squares = new ArrayList<>();
		for (int i = 1; i < 5; i++)
			squares.add(i * i);
		System.out.println(new ObjectAnalyzerBook().toString(squares));
	}
}

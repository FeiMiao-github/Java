package interfaceMetod;

import companyTest.Employee;

public class Main {
	public static void main(String args[]) {
		Employee employee1 = new Employee("Harry", 434);
		Employee employee2 = new Employee("Mary", 324.0);
		int i = employee1.compareTo(employee2);
		System.out.println(i);
	}
}

package interfaceMetod;

import companyTest.*;

public class InterfaceDemo {
	public static void main(String [] args) {
		Employee employee = new Employee("Harry", 123.0);
		Manager manager = new Manager("manager", 1234.0);
		
		System.out.println(employee instanceof Employee);
		System.out.println(manager instanceof Manager);
		System.out.println(Manager.class.equals(Employee.class));
		
		String dec1 = "this is first declaration! ";
		String dec2 = "this is second declaration!";
		DestinationDemo deInstance1 = new DestinationDemo(dec1);
		DestinationDemo deInstance2 = new DestinationDemo(dec2);
		System.out.println(deInstance1.getName(employee) + "====" + deInstance1.getDeclaration());
		System.out.println(deInstance2.getName(manager) + "====" + deInstance2.getDeclaration());
	}
}

package interfaceMetod;

import companyTest.Employee; 

public class DestinationDemo implements ImplementDemo2<Employee> /* ImplementDemo2 */ {
	
	private String name;
	private String declaration = "";
	
	public DestinationDemo(String declaration) {
		this.declaration += declaration;
	}
	/*
	public String getName(Object other) {
	 
		if (!(other instanceof Employee)) return null;
		this.name = ((Employee) other).getName();
		return this.name;
	}
	*/
	
	public String getName(Employee e) {
		this.name = e.getName();
		return this.name;
	}
	
	public String getDeclaration() {
		return this.declaration;
	}
}

package companyTest;

import interfaceMetod.CompareDemo;

public class Employee implements CompareDemo<Employee> {
	private String name;
	private double salary;
	
	public Employee(String n, double salary){
		this.name = n;
		this.salary = salary;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public String toString() {
		return getClass().toString() + "---[name: " + 
				getName() + ", salary: $" + 
				String.format("%.2f", this.getSalary()) + "]";
	}
	
	public void test() {
		System.out.println("Hello!");
	}
	
	public int compareTo(Employee e) {
		return Double.compare(salary, e.salary);
	}
}

package toStringmethod;

public class Employee {
	private String name;
	private double salary;
	
	Employee(String n, double salary){
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
		return getClass().toString() + "[name: " + 
				getName() + "salary: $" + 
				this.getSalary() + "]";
	}
}

package dataSetDemo;

public class Employee {
	private  String name = null;
	private int id = 0;
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
}

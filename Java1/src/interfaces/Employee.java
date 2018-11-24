package interfaces;

import java.time.LocalDate;
import java.util.Date;

public class Employee implements Comparable<Employee>, Cloneable {
	private String name;
	private double salary;
	private LocalDate hireDay = null;
	private Date hireDate = null;
	
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	/** 
	 * @param name
	 * @param salary
	 * @param y year
	 * @param m month
	 * @param d day of month
	 */
	@SuppressWarnings("deprecation")
	public Employee(String name, double salary, int y, int m, int d) {
		this.name = name;
		this.salary = salary;
		this.hireDay = LocalDate.of(y, m, d);
		this.hireDate = new Date(y, m, d);
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public int compareTo(Employee other) {
		return Double.compare(salary, other.salary);
	}
	
	public LocalDate getHireDay() {
		return this.hireDay;
	}
	
	public Employee clone() throws CloneNotSupportedException {
		Employee obj = (Employee)super.clone();
		boolean flag = false;
		if (flag) {
			obj.hireDate = ((Date)hireDate.clone());
		}
		return obj;/* 浅拷贝 */
	}
	
	@SuppressWarnings("deprecation")
	public void setHireDay(int m, int n, int d) {
		hireDay = LocalDate.of(m, n, d);
		hireDate.setYear(m);
		hireDate.setMonth(n);
		hireDate.setDate(d);
	}
	
	public String toString() {
		return ("name: " + name + "====salary: " + salary
				+ "====hireday: " + hireDay.toString());
	}
	
	@SuppressWarnings("deprecation")
	public String toStrings() {
		return ("name: " + this.name + "====hiredate: " + hireDate.getYear() 
			+ "-" + hireDate.getMonth() + "-" + hireDate.getDate());
	}
}

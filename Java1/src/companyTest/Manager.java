package companyTest;

public class Manager extends Employee{
	private double bonus;
	
	public Manager(String n, double s){
		super(n, s);
		bonus = 0;
	}
	
	public void setBonus(double b) {
		this.bonus =  b;
	}
	
	public double getSalary() {
		return super.getSalary() + this.bonus;
	}
}

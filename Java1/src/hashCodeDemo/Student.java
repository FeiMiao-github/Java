package hashCodeDemo;

public class Student {
	private String name;
	private static int nextId = 0;
	private int stuId;
	private int Id;
	
	public Student(String name){
		this.name = name;
		stuId = nextId++;
		Id = this.hashCode();
	}
	
	public String getMsg() {
		return name + "---" + stuId;
	}
	
	public int getId() {
		return this.Id;
	}
	
	public int getStuId() {
		return this.stuId;
	}
	
	public String getName() {
		return name;
	}
}

package hashCodeDemo;

public class ElementarySchoolStudent extends Student{
	private int stuGrade;
	private ElementStudentClass stuClass; 
	
	public ElementarySchoolStudent(String name, int sG, ElementStudentClass c) {
		super(name);
		stuGrade = sG;
		this.stuClass = c;
	}
	
	public String getMsg() {
		return getName() + "---Class: " + stuClass + ", Grade: " + stuGrade; 
	}
}

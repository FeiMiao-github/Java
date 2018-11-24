package hashCodeDemo;

import java.util.ArrayList;

public class Main {
	public static String []name = {
		"zhao", "qian", "sun", "li", "Mary"
	};

	public static void main(String[] args) {
		Student stuM = new Student("Mary");
		Student stuH = new Student("Harry");
		ElementarySchoolStudent stuE = new ElementarySchoolStudent("小学生", 1, ElementStudentClass.CLASS_5);
		
		System.out.println(stuM.getMsg() + Integer.toHexString(stuM.getId()));
		System.out.println(stuH.getMsg() + Integer.toHexString(stuH.getId()));
		System.out.println(stuE.getMsg() + "\t" + Integer.toHexString(stuH.getId()));
		
		ArrayList<Student> arrayStudent = new ArrayList<>();
		for (String ename: name) {
			arrayStudent.add(new Student(ename));
		}
		printStu(arrayStudent);
		
		System.out.println("changing!");
		arrayStudent.set(3, new Student("zhou"));
		System.out.println(arrayStudent);
		System.out.println(arrayStudent.set(3, new Student("zhou")));
		printStu(arrayStudent);
		
		Student []arrayStu = new Student[arrayStudent.size()];
		while (arrayStudent.size() > 0) {
			Student stu = arrayStudent.get(arrayStudent.size()-1);
			arrayStu[arrayStudent.size() - 1] = stu;
			arrayStudent.remove(arrayStudent.size() - 1);
		}
		
		for (Student eStu: arrayStu) {
			System.out.println(eStu.getName() + ": " + eStu.getStuId());
		}
	}
	
	public static void printStu(ArrayList<Student> as) {
		for (int i = as.size()-1; i >= 0; i--)
			System.out.println(as.get(i).getName() + "'s sudent ID is " + as.get(i).getStuId());
	}
}

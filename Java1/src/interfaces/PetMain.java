package interfaces;

import java.util.ArrayList;

public class PetMain {
	
	@SuppressWarnings("unchecked")
	public static void main(String [] args) throws CloneNotSupportedException {
		PetStore cat = new Cat("miao");		/* 接口回调 */
		PetStore dog = new Dog("wang");		/* 接口回调 */
		
		dog.eatFood(PetSpecies.Dog);
		cat.eatFood(PetSpecies.Dog);
		
		dog.say();	/*  优先继承超类中的方法  */
		cat.say();
		
		/* Object clone */
		ArrayList<String> s = new ArrayList<>();
		s.add("hello");
		ArrayList<String> sa = s;
		System.out.println(sa == s);
		
		ArrayList<String> sb = (ArrayList<String>)s.clone();
		System.out.println((ArrayList<String>)sb == s);
		
		Employee e1 = new Employee("Employee1", 200, 2000, 1, 1);
		Employee e2 = e1.clone();
		System.out.println("BEFORE---toString() ");
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println("BEFORE---toStrings() ");
		System.out.println(e1.toStrings());
		System.out.println(e2.toStrings());
		
		e2.setHireDay(2000, 1, 2);
		
		System.out.println("CLONE---toString() ");
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println("CLONE---toStrings() ");
		System.out.println(e1.toStrings());
		System.out.println(e2.toStrings());
		
		System.out.println("e1==e2?  =====" + (e1 == e2) + "=====");
		
		System.out.println("COPY---toString()");
		Employee e3 = e1;
		e3.setHireDay(2000, 1, 2);
		System.out.println(e1.toString());
		System.out.println(e3.toString());
		System.out.println("COPY---toStrings()");
		System.out.println(e1.toStrings());
		System.out.println(e2.toStrings());
		
		System.out.println("e1==e3?  =====" + (e1 == e3) + "=====");
		
	}
}

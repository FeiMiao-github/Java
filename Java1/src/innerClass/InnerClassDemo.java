package innerClass;

import org.junit.Test;

public class InnerClassDemo {
	class Bird{
		public String getName() {
			return this.name;
		}
		
/*		public static boolean sendName() {
		return false;
		}
		*/
		
		public void printOuterClassName() {
			System.out.println("name3 = " + InnerClassDemo.this.name);
		}
		private String name = "Bird";
	}
	
	@Test
	public void test() {
		String innerClassName = InnerClassDemo.Bird.class.toString();
		System.out.println("innerClassName = " + innerClassName);
		System.out.println("name = " + name);
		System.out.println("name2 = " + this.new Bird().getName());
	}
	
	public String name = "InnerClassDemo";
}

package arrayListMethod;

import java.util.ArrayList;
import companyTest.*;

public class Main {
	private static String[] nameList = {
			"Has", "Siwen", "Aileto", "Alex",
			"Sally", "Sam", "Simen", "Hanxe"
	};
	
	private static double[] salary = {
			300, 400, 200, 150,
			350, 240, 320, 360
	};
	
	public static void main(String[] args) {
		/* Employee array list*/
		ArrayList<Employee> staff = new ArrayList<Employee>();
		
		/* Omit the parameter */
		ArrayList<Employee> staffArray = new ArrayList<>(20);
		
		/* add elements to ArrayList staffArray */
		staff.add(new Employee("Ham", 234.1));
		staff.add(new Manager("Marry", 400.0));
		Manager m = (Manager) staff.get(1);
		m.setBonus(131.2);
		
		/* set array size, ensure capacity */
		staffArray.ensureCapacity(100);
		
		System.out.println("staff ArrayList's size: " + staff.size());
		System.out.println("staffArray ArrayList's size: " + staffArray.size());
		/* OUTPUT:
		 * staff ArrayList's size: 2
		 * staffArray ArrayList's size: 0
		 * */
		System.out.println(staff.get(0).toString());
		System.out.println(staff.get(1).toString());
		
		int tempSize = staff.size() + nameList.length;
		while(staff.size() < tempSize) {
			int index = staff.size() - tempSize + nameList.length;
			Employee ele = new Employee(nameList[index], salary[index]);
			staff.add(ele);
		}
		Employee[] e = new Employee[staff.size()];
		staff.toArray(e);
		for(Employee ele: e) {
			System.out.println(ele);
		}
		/* OUTPIT:
		 * class companyTest.Employee---[name: Ham, salary: $234.10]
		 * class companyTest.Manager---[name: Marry, salary: $531.20]
		 * class companyTest.Employee---[name: Has, salary: $300.00]
		 * class companyTest.Employee---[name: Siwen, salary: $400.00]
		 * class companyTest.Employee---[name: Aileto, salary: $200.00]
		 * class companyTest.Employee---[name: Alex, salary: $150.00]
		 * class companyTest.Employee---[name: Sally, salary: $350.00]
		 * class companyTest.Employee---[name: Sam, salary: $240.00]
		 * class companyTest.Employee---[name: Simen, salary: $320.00]
		 * class companyTest.Employee---[name: Hanxe, salary: $360.00]
		 * */
		System.out.println();
		System.out.println("print staff");
		for (Employee ele: staff) {
			System.out.println(ele);
		}
		/* OUTPIT:
		 * print staff
		 * class companyTest.Employee---[name: Ham, salary: $234.10]
		 * class companyTest.Manager---[name: Marry, salary: $531.20]
		 * class companyTest.Employee---[name: Has, salary: $300.00]
		 * class companyTest.Employee---[name: Siwen, salary: $400.00]
		 * class companyTest.Employee---[name: Aileto, salary: $200.00]
		 * class companyTest.Employee---[name: Alex, salary: $150.00]
		 * class companyTest.Employee---[name: Sally, salary: $350.00]
		 * class companyTest.Employee---[name: Sam, salary: $240.00]
		 * class companyTest.Employee---[name: Simen, salary: $320.00]
		 * class companyTest.Employee---[name: Hanxe, salary: $360.00]
		 * */
	}
}

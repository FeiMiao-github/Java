package reflectionMethod;

import companyTest.Employee;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class reflectionTest3 {
	public static void main(String[] args) {
		Employee e = new Employee("harry", 1234.0);
		// System.out.println(e.name);cannot invoke it directly
		printFieldsValue(e);
		
		/* Method类中的invoke Method */
		/* 它允许调用包装在当前Method对象中的方法 */
		/* Object invoke(Object obj, Object... args)*/
		
		String methodName[] = {"getSalary", "getName", "raiseSalary", "test"};
		Class<?> cEmployee = Employee.class;
		try {
			Method[] methods = {
					cEmployee.getMethod(methodName[0]),
					cEmployee.getMethod(methodName[1]),
					// cEmployee.getMethod(methodName[2], double.class),
					cEmployee.getMethod(methodName[3])
			};
			
			methods[2].invoke(e);
		} catch (Exception er) {er.printStackTrace();}
		
	}
	
	public static void printFieldsValue(Object obj) {
		try {
			Class<?> c1 = obj.getClass();
			Field[] fields = c1.getDeclaredFields();
			AccessibleObject.setAccessible(fields, true);
			int i = 0;
			for (Field f: fields) {
				String modifier = Modifier.toString(f.getModifiers());
				System.out.println(i++ + " " + modifier + " " + f.getName()
				 + " = " + f.get(obj));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

package reflectionMethod;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;

import companyTest.Employee;

public class ReflectionReviewDemo {

	public static void main(String[] args) {
		/* 反射 */
		/* 能够分析类的能力的程序叫反射 */
		
		/* Class 类 */
		/**返回Class类型的实例的三种方法： */
		/** 	1. getClass()	*/
		Employee employ;// 首先要初始化
		employ = new Employee("Hans", 123);
		Class<?> c1 = employ.getClass();
		System.out.println("e.getClass()=====" + c1 +"=====" + c1.getName());
		/** 	2.forName(String s)	 , 注意全名*/
		try {
			Class<?> c2 = Class.forName("companyTest.Employee");
			System.out.println("e.getClass()=====" + c2 +"=====" + c2.getName());
		} catch (Exception er) {
			er.printStackTrace();
		}
		/** 	3.class 	*/
		Class<?> c3 = Employee.class;
		System.out.println("e.getClass()=====" + c3 +"=====" + c3.getName());
		
		/***  	可以使用 == 比较两个Class 对象		 */
		System.out.println("c1 == c3=====" + (c1==c3));
		System.out.println("c1 == Double.class=====" + (c1 == Double.class));
		
//		/** 	使用newInstance() 创建类的实例 		*/
//			Object employee = c1.newInstance();
		
		System.out.println();
		
		/*		使用反射类分析类的能力 		*/
		String modifier =  Modifier.toString(c1.getModifiers());
		System.out.println(modifier + " " + c1.getSimpleName() + "{");
		printConstructor(c1);
		System.out.println();
		printMethods(c1);
		System.out.println();
		printFields(c1);
		System.out.println("}");
		
		System.out.println();
		
		
		System.out.println(toString(employ));
	}
	
	/* 显示构造器 */
	public static void printConstructor(Class<?> c) {
		Constructor<?>[] constructors = c.getDeclaredConstructors();
		for (Constructor<?> cEle : constructors) {
			String name = cEle.getName();
			String modifier = Modifier.toString(cEle.getModifiers());
			Type[] parameters = cEle.getParameterTypes();
			
			System.out.print("\t" + modifier + " " + name + "(");
			for (int i = 0; i < parameters.length; i++) {
				if (i > 0) System.out.print(", ");
				System.out.print(parameters[i].getTypeName());
			}
			System.out.println(");");
		}
	}
	
	/* 显示方法 */
	public static void printMethods(Class<?> c) {
		Method[] methods = c.getDeclaredMethods();
		for (Method m: methods) {
			String modifier = Modifier.toString(m.getModifiers());
			String name = m.getName();
			Type[] parameters = m.getParameterTypes();
			
			System.out.print("\t" + modifier + " " + name + "(");
			for (int i = 0; i < parameters.length; i++) {
				if (i > 0) System.out.print(", ");
				System.out.print(parameters[i].getTypeName());
			}
			System.out.println(");");
		}
	}
	
	public static void printFields(Class<?> c) {
		Field[] fields = c.getDeclaredFields();
		
		/* setAccessible 是一个AccessibleObject 类中的方法， 它是
		 * Field, Method和 Constructor 的公共超类*/
		/*  覆盖访问权限 */
		Field.setAccessible(fields, true);
		for (Field f : fields) {
			String modifier = Modifier.toString(f.getModifiers());
			String name = f.getName();
			System.out.println(name);
			System.out.println("\t" + modifier + " " + name + ";");
		}
	}
	
	
	private static ArrayList<Object> visited = new ArrayList<>();
	public static String toString(Object obj) {
		if (obj == null) return "null";
		if (visited.contains(obj)) return "...";
		visited.add(obj);
		Class<?> c1 = obj.getClass();
		if (c1 == String.class) return (String)obj;
		
		if(c1.isArray()) {
			String r = c1.getComponentType().getTypeName() + "[]{";
			for (int i = 0; i < Array.getLength(obj); i++) {
				if (i > 0) r += ", ";
				Object val = Array.get(obj, i);
				if (c1.getComponentType().isPrimitive()) r += val;
				else r += toString(obj);
			}
			
			return r +="}";
		}
		
		String r = c1.getName();
		
		do {
			r +="[";
			Field[] fields = c1.getFields();
			AccessibleObject.setAccessible(fields, true);
			
			for (Field f: fields) {
				if (!Modifier.isStatic(f.getModifiers())){
					if (!r.endsWith("[")) r += ", ";
					r += f.getName() + " = ";
					try {
						Class<?> t = f.getType();
						Object val = f.get(obj);
						if (t.isPrimitive()) r += val;
						else r += toString(val);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			r += "]";
			c1.getSuperclass();
		} while (c1 != null);
		
		
		return r;
	}
}

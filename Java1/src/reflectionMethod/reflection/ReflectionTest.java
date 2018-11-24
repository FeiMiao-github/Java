package reflectionMethod.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * This program uses reflection to print all features of a class
 * @version 
 * @author Cay Horstman
 * */
public class ReflectionTest extends Fu{
	public static void main(String [] args) {
		String name;
		
		if (args.length > 0) name = args[0];
		else {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name: ");
			name = in.next();
			in.close();
		}
		
		try {
			Class<?> c1 = Class.forName(name);
			Class<?> superc1 = c1.getSuperclass();
			String modifiers = Modifier.toString(c1.getModifiers());
			/* getModifiers() 返回一个描述构造器， 域， 方法的修饰符的整型数值*/
			/* 通过class Modifier中的方法可以分析这个值*/
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print("class " + name);
			if (superc1 != null && superc1 != Object.class) {
				System.out.println(" extends " + superc1.getName());
			}
			
			System.out.println("\n{\n");
			printConstructors(c1);
			System.out.println();
			printMethods(c1);
			System.out.println();
			printFields(c1);
			System.out.println("}");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	/**
	 * Print all constructors of a class
	 * @param c1 a class
	 * */
	public static void printConstructors(Class<?> c) {
		Constructor<?> [] constructors = c.getDeclaredConstructors();
		/* 返回包含Constructor 对象的数组， 其中包含了该类的所有构造器 */
		/* 使用getConstructor 方法可以获取该类的所有public修饰的构造器 */
		for (Constructor<?> con: constructors) {
			String name = con.getName();
			System.out.print("\n\t");
			String modifiers = Modifier.toString(con.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(name + "(");
			
			Class<?>[] paramTypes = con.getParameterTypes();
			/* getParameterTypes()返回描述constructor或method的参数类型的Class[] */
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
 		}
	}
	
	/**
	 * Prints all methods of a class
	 * @param c1 a class */
	public static void printMethods(Class<?> c) {
		Method[] methods = c.getDeclaredMethods();
		/* 使用getMethods()方法可以获取所有的public方法， 包括从超类中继承来的 */
		/* 使用getDeclaredMethods() 方法可以返回这个类或接口的所有方法， 
		 * 但是不包括从超类中继承的方法 */
		
		for (Method m: methods) {
			/* get the type of the item the method returned 
			 * */
			Class<?> retType = m.getReturnType();
			/* getReturnType()描述return类型的Class对象*/
			String name = m.getName();
			
			System.out.print("\n\t");
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(retType + " " + name + "(");
			// System.out.print("name:" + name + "\tmodifiers: " + modifiers + "\tretType: " + retType);

			// print the parameter types
			Class<?>[] paramTypes = m.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++) {
				if (i > 0) System.out.print(", ");
				System.out.print(paramTypes[i]);
			}
			System.out.println(");");
		}
		
		/**
		 * Print all fields of a class*/
	}
	
	/**
	 * Prints all fields of a class
	 * @param c1 a class */
	public static void printFields(Class<?> c) {
		Field[] fields = c.getDeclaredFields();
		/* getFields 方法返回一个包含Field对象的数组, 记录了这个类或其超类的public域*/
		/* getDeclaredFields() 方法返回一个包含这个类全部Field对象的数组， 但不包括超类*/
		for (Field f: fields) {
			Class<?> type = f.getType();
			String name = f.getName();
			
			System.out.print("\n\t");
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0 )System.out.print(modifiers + " ");
			System.out.println(type + " " + name + ";");
		}
		
	}
	
}

package methods;

import java.lang.reflect.Method;

/** @version 1.0
 * 
 * @author JZ
 *
 */
public class MethodTableTest {
	
	public static void main(String[] args) throws Exception {
		
			Method square = MethodTableTest.class.getMethod("square", double.class);
			Method sqrt = Math.class.getMethod("sqrt", double.class);
			
			printTable(1, 10, 10, sqrt);
			printTable(1, 10, 10, square);
	}
	
	/**
	 * Returns the square of a num
	 * @param x double
	 * @return x squared double
	 * */
	public static double square(double x) {
		return x * x;
	}
	
	/** 
	 * Prints a table with x- and y value for a method
	 * @param from the lower bound for the x-values
	 * @param to the upper bound for the x-values
	 * @param n the number of rows in the table
	 * @param f a method with double parameter and double return value*/
	
	public static void printTable(double from, double to, int n, Method f) {
		System.out.println(f);
		double dx = (to - from) / (n - 1);
		for (double x = from; x <= to; x += dx) {
			try {
				/* 调用静态方法， 所以invoke 的第一个参数是null */
				double y = (Double)f.invoke(null, x);
				System.out.printf("%10.4f/t|/t%10.4f%n", x, y);
			} catch(Exception e) {e.printStackTrace();}
		}
	}
}

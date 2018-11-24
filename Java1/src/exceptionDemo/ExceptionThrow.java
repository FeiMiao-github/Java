package exceptionDemo;

import java.io.*;

import org.junit.Test;
public class ExceptionThrow {
	@Test
	public void test() throws EOFException {
		throw new EOFException();
	}
	
	public static void main(String [] args) {
		int []a = {1, 2, 3};
		int i = 0;
		try {
			for (; i < 4; i++)
				System.out.print(((i > 0) ? ", " : "")  +  a[i]);
			System.out.println();
		} catch(ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException(i);
		} finally {
			System.out.println("just for fun!");
		}
	}
}

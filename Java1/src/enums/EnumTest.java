package enums;

import java.util.Scanner;

public class EnumTest {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
		
		String input = in.next().toUpperCase();
		/* turn all of characters to upper case*/
		Size size = Size.valueOf(input);
		
		System.out.println("size: " + size);
		System.out.println("abbreviation = " + size.getAbbreviation());
		if (size == Size.EXTRA_LARGE) System.out.println("Good job--you paid attention to the _.");
		
		System.out.println();
		System.out.println("Class:   java.lang.Enum<E>");
		System.out.println("Mehhod:  int compareTo(E other)");
		System.out.println("compare to medius, you are" + " \t" +((size.compareTo(Size.MEDIUM) > 0)?"larger":"smaller"));
		in.close();
	}
}

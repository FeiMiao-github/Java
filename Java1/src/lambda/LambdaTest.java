package lambda;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class LambdaTest {
	public static void main(String[] args) {
		String [] planets = new String[] {
				"Mercury", "Venus", "Earth",
				"Mars", "Jupiter", "Saturn",
				"Uranus", "Neptune"
		};
		
		System.out.println(Arrays.toString(planets));
		System.out.println("Sorted in dictionary order: ");
		Arrays.sort(planets);
		System.out.println(Arrays.toString(planets));
		
		System.out.println("Sorted by length: ");
		// 实现了compareTo接口
		Arrays.sort(planets, (first, second) -> first.length() - second.length());
		System.out.println(Arrays.toString(planets));
		
		Timer t = new Timer(1000, event -> System.out.println("The time is " + new Date()));
		Timer t1 = new Timer(2000, System.out::println);
		t1.start();
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

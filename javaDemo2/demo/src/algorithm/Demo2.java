package algorithm;

import edu.princeton.cs.algs4.StdDraw;

public class Demo2 {
	public static void main(String[] args) {
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(0, 100.0);
		
		StdDraw.setPenColor(StdDraw.BLUE);

		StdDraw.setPenRadius(.001);
		for (var i = 0; i < 100; i++)
			StdDraw.line(i, 0, i, 100);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.circle(50, 50, 20);
	}
}

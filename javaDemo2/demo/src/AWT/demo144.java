package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class demo144 {
	public static void main(String[] args) {
		Frame f = new Frame("计算器");
		Panel p1 = new Panel();
		p1.add(new TextField(30));
		f.add(p1, BorderLayout.NORTH);
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(3, 5, 4, 4));
		
		String[] name = {
				"1", "2", "3", "4", "5", "6", "7",
				"8", "9", "0", "+", "-", "*", "/", "."
		};
		
		for (var e: name) {
			p2.add(new Button(e));
		}
		
		f.add(p2);
		f.pack();
		f.setVisible(true);
	}
}

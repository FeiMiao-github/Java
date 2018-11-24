package anonymousInnerClass;

import javax.swing.JOptionPane;

public class AnonymousInnerClassTest {
	/*
	 * Compiled from "AnonymousInnerClassTest.java"
		public class anonymousInnerClass.AnonymousInnerClassTest {
  			public anonymousInnerClass.AnonymousInnerClassTest(); //constructor
  			public static void main(java.lang.String[]);
		}
	 * */
	public static void main(String[] args) {
		
		TalkingClock clock = new TalkingClock();
		clock.start(1000, true);
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

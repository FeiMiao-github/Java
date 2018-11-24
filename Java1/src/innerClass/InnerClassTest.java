package innerClass;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock(1000, true);
		clock.start();
		
		Timer t = new Timer(2000, clock.new TimePrinter());
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

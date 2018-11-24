package innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.junit.Test;

public class AnonymousInnerClass {
	
	
	/* LOCAL INNER CLASS */
	public void start(int interval, boolean beep) {
		class TimePrinter implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				//  Auto-generated method stub
				System.out.println("At the tone, the time is "  + new Date());
				if (beep) Toolkit.getDefaultToolkit().beep();
			}
		}
		
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
	
	
	/* Anonymous Inner class */
	public void starts(int interval, boolean beep) {
		ActionListener listener = new ActionListener() {
			/* the syntax is vary cryptic indeed */
			/* create a new object of a class that implements the ActionListener 
			 * interface, where the requires method is the one defined inside the braces{} */
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("At the tone, the time is " + new Date());
				if (beep) Toolkit.getDefaultToolkit().beep();
			}
		};
		
		Timer t = new Timer(interval, listener);
		 t.start();
		
		JOptionPane.showMessageDialog(null, "Quit program");
		System.exit(0);
	}
	
	@Test
	public void test() {
		starts(50, true);
	}
}

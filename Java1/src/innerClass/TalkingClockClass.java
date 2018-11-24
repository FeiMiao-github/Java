package innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.junit.Test;

public class TalkingClockClass {
	
	public void start(boolean beep, int interval) {
		class TimePrinter implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("At the tone, the time is " + new Date());
				if (beep) Toolkit.getDefaultToolkit().beep();
			}
		}
		
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit?");
		System.exit(0);
	}
	
	@Test
	public void test() {
		TalkingClockClass t = new TalkingClockClass();
		System.out.println("start");
		t.start(true, 1000);
	}
	
}

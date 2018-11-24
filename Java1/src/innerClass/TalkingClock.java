package innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;

public class TalkingClock {
	private boolean beep;
	private int interval;
	
	public TalkingClock(int interval, boolean beep) {
		this.beep = beep;
		this.interval = interval;
	}
	 
	public void start() {
		// ActionListener listener = this.new TimePrinter();
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}
	
	public class TimePrinter implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			System.out.println("At the tone, the time is " + new Date() + TalkingClock.this.beep);
			if (beep) Toolkit.getDefaultToolkit().beep();
		}
	}
}

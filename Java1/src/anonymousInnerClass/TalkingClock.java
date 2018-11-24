package anonymousInnerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

public class TalkingClock {
	
	public void printHello() {
		System.out.println("deny");
	}
	
	public void start(int interval, boolean beep) { 
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("At the tone, the time is " + new Date());
				if(beep) Toolkit.getDefaultToolkit().beep();
			}
		};
		
		Timer t = new Timer(1000, listener);
		t.start();
	}
}

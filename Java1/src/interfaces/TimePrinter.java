package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.Toolkit;

public class TimePrinter implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// Invoked when an action occurs.
		System.out.println("At the tone, the time is " + new Date());
		Toolkit.getDefaultToolkit().beep();
	}
}

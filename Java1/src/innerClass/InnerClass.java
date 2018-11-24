package innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import interfaces.TimePrinter;

/**
 * @author JZ
 *
 */
public class InnerClass {	
	
	public static void start() {
		class TimePrinter implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("At the tone. the time is " + new Date());
				if (true) Toolkit.getDefaultToolkit().beep();	
			}
		}
		
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(1000, listener);
		t.start();
	}
	
	public static void main(String[] args) {
		InnerClass.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

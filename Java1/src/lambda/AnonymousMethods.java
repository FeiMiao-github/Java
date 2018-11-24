package lambda;

import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class AnonymousMethods {
	public static void main(String [] args) {
		Timer t = new Timer(500, e -> {
			System.out.println("functional interface!");
		});
		t.start();
		
		// 实现了接口方法    public void actionPerformed(ActionEvent e);
		JOptionPane.showMessageDialog(null, "Quit P?");
		Toolkit.getDefaultToolkit().beep();
		System.exit(0);
	}
}

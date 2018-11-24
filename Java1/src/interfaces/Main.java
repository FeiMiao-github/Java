package interfaces;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Main {
	public static void main(String [] args) {
		PetFoodSupplior.welcome();
		ImplementsClass ic = new ImplementsClass();
		ic.eatFood(PetSpecies.Dog);
		ic.foodSupply();
		// ic.welcome(); // error
		
		ActionListener ic2 = new TimePrinter();
		Timer t = new Timer(1000, ic2);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit program!");
		System.exit(0);
	}
}

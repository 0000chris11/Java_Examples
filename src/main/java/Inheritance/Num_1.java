package Inheritance;
import javax.swing.JOptionPane;
public class Num_1 extends Super{
	//INHERITANCE CLASS.NUM1 WITH 4 METHODS and 2 OVERRIDE METHODS
	
	@Override
	public void otherThing() {
		JOptionPane.showMessageDialog(null,"From Class N1");
	}
	@Override
	public void noise() {
		System.out.println("WE ARE NUMBER ONE");
	}
	
}

package inheritance_d;

import javax.swing.JOptionPane;

public class SuperExt1 extends Super{

	//INHERITANCE CLASS.NUM1 WITH 4 METHODS and 2 OVERRIDE METHODS
	
	@Override
	public void abstractMethod1() {
		JOptionPane.showMessageDialog(null,"From Class N1");
	}
	@Override
	public void abstractMethod2() {
		System.out.println("WE ARE NUMBER ONE");
	}
	
}

package inheritance_d;

import javax.swing.JOptionPane;

public class SuperExt2 extends Super{
	//INHERITANCE CLASS.NUM2 WITH 1 OF 2 METHODS OVERRIDE
	
	@Override
	public void normalMethod2(int x) {
		System.out.println("normalMethod2 overrided from SuperExt2: " + x);
	}
	@Override
	public void abstractMethod1() {
		JOptionPane.showMessageDialog(null,"abstractMethod1 overrided from SuperExt2");
	}
	@Override
	public void abstractMethod2() {
		System.out.println("abstractMethod2 overrided from SuperExt2");
	}
}

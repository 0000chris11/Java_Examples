package Inheritance;
import javax.swing.JOptionPane;
public class Num_2 extends Super{
	//INHERITANCE CLASS.NUM2 WITH 1 OF 2 METHODS OVERRIDE
	
	
	public void setThing(int x) {
		System.out.println("this from the class InhNun2 : "+x);
	}
	@Override
	public void otherThing() {
		JOptionPane.showMessageDialog(null,"From Class N2");
	}
	@Override
	public void noise() {
		System.out.println("DUDE IS GLOOP!!!");
	}
}

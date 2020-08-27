package ClassExamples;
import javax.swing.JOptionPane;
//Muestra una ventana
public class Windows {
	public static void main(String[] args) {
		
		String number1 = JOptionPane.showInputDialog("Enter First Number");
		String number2 = JOptionPane.showInputDialog("Enter Second Number");
		//Changing String to int
		int num1 = Integer.parseInt(number1);
		int num2 = Integer.parseInt(number2);
		int sum = num1 + num2;
		
		JOptionPane.showMessageDialog(null, "The Answer is: "+sum, "Result", JOptionPane.PLAIN_MESSAGE);
		
		//JFrame jf = new JFrame();
		
		JOptionPane.showMessageDialog(null, "The Answer is: "+sum, "Result", JOptionPane.WARNING_MESSAGE);
	}
}

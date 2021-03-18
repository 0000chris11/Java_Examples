package CounterTry;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class CounterController extends JFrame implements ActionListener{
	CounterView form;
	
	CounterController(CounterView cv){
		form = cv;
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.getPlus().addActionListener(this);
		form.getMinus().addActionListener(this);
		form.setVisible(true);
		
		}
	public void actionPerformed(ActionEvent e) {
		//CounterView cv = new CounterView();
		int x = 0;
		//JOptionPane.showMessageDialog(null,e.getActionCommand());
		
		if(e.getActionCommand().equals("PLUS")) {
			JLabel nn = new JLabel();
			form.setX(++x);
			System.out.println("ddd");
			//I HAD NO IDEA HOW TO DO THIS IN THIS WAY
			
		}
	
	}
	
	
}

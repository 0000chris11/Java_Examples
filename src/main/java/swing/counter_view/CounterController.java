package swing.counter_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class CounterController extends JFrame implements ActionListener{
	CounterView counterView;
	
	CounterController(CounterView cv){
		counterView = cv;
		counterView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		counterView.getPlus().addActionListener(this);
		counterView.getMinus().addActionListener(this);
		counterView.setVisible(true);
		
		}
	public void actionPerformed(ActionEvent e) {
		int x = 0;
		
		if(e.getActionCommand().equals("PLUS")) {
			counterView.setX(++x);
			System.out.println("ddd");
			//I HAD NO IDEA HOW TO DO THIS IN THIS WAY	
		}
	}
}

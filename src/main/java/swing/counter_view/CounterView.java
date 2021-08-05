package swing.counter_view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class CounterView extends JFrame {

	private JPanel contentPane;
	private Button plus;
	private Button minus;
	private JLabel count;
	private int xValue = 0;
	
	
	public Button getPlus() {
		return plus;
	}

	public void setPlus(Button plus) {
		this.plus = plus;
	}

	public Button getMinus() {
		return minus;
	}

	public void setMinus(Button minus) {
		this.minus = minus;
	}

	public JLabel getCount() {
		return count;
	}

	public void setCount(JLabel c) {
		count = c;
	}

	public int getXValue() {
		return xValue;
	}

	public void setX(int x) {
		this.xValue = x;
	}

	public CounterView() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		//-----------------------------------------------------------------------
		plus = new Button("PLUS");
		plus.setFont(new Font("AR DARLING", Font.PLAIN, 16));
		plus.setForeground(Color.BLACK);
		plus.setBackground(Color.LIGHT_GRAY);
		plus.setBounds(10, 73, 89, 99);
		contentPane.setLayout(null);
		contentPane.add(plus);
		//----------------------------------------------------------------
		minus = new Button("MINUS");
		minus.setFont(new Font("Dialog", Font.PLAIN, 16));
		minus.setBackground(Color.LIGHT_GRAY);
		minus.setBounds(335, 73, 89, 99);
		contentPane.add(minus);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(new Color(255, 255, 255));
		layeredPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		layeredPane.setBackground(Color.BLACK);
		layeredPane.setBounds(105, 11, 224, 239);
		contentPane.add(layeredPane);
		
		count = new JLabel(Integer.toString(xValue));
		count.setHorizontalAlignment(SwingConstants.CENTER);
		count.setFont(new Font("Tahoma", Font.PLAIN, 50));
		count.setBounds(10, 11, 204, 217);
		layeredPane.add(count);
		
		
		
	}
}

package class_examples_d;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;


public class WindowM1 extends JFrame{
	
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JLabel jl4;
	private JTextField jtf1;
	private JTextField jtf2;
	private JTextField jtf3;
	private JPasswordField jpf;
	
	public WindowM1() {
		super("Window");
		setLayout(new FlowLayout());
		
		jl1 = new JLabel("Field 1");
		jl1.setToolTipText("this is gonna show somewhere");
		//text that appear when you put the cursor over text/image
		add(jl1);
		
		jtf1 = new JTextField(10);
		add(jtf1);
		
		jl2 = new JLabel("Field 2");
		add(jl2);
		jtf2 = new JTextField("text is what you see");
		add(jtf2);
		
		jl3 = new JLabel("Field 3");
		add(jl3);
		jtf3 = new JTextField("XXXXX", 20);
		jtf3.setEditable(false);
		add(jtf3);
		
		jl4 = new JLabel("Field 4");
		add(jl4);
		jpf = new JPasswordField("boio");
		add(jpf);
		
		controller cll = new controller();
		jtf1.addActionListener(cll);
		jtf2.addActionListener(cll);
		jtf3.addActionListener(cll);
		jpf.addActionListener(cll);
	}
	
	private class controller implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String st = "";
			
			if(e.getSource()==jtf1) {
				st = String.format("Field 1: %s", e.getActionCommand());
			}else if(e.getSource()==jtf2) {
				st = String.format("Field 2 %s", e.getActionCommand());
			}else if(e.getSource()==jtf3) {
				st = String.format("Filed 3: %s", e.getActionCommand());
			}else if(e.getSource()==jpf){
				st = String.format("Password 4: %s", e.getActionCommand());
			}
			
			JOptionPane.showMessageDialog(null, st);
		}
		
	}
	
}

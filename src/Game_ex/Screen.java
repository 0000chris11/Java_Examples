package Game_ex;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class Screen extends JFrame{
	private GraphicsDevice gd;
	
	public Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Draw());
		setUndecorated(false);
		setResizable(false);
		setTitle("Window");
		setSize(1024,768);
		setVisible(true);
		setLocationRelativeTo(null);
		
		GraphicsEnvironment env = 
				GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = env.getDefaultScreenDevice();
		
	}
	public static void main(String[] args) {
		new Screen();
	}
}

package swing.game_ex;

import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Screen extends JFrame{

	Screen() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		add(new Draw());
		setUndecorated(false);
		setResizable(false);
		setTitle("Window");
		setSize(1024,768);
		setVisible(true);
		setLocationRelativeTo(null);
		
		GraphicsEnvironment env = 
				GraphicsEnvironment.getLocalGraphicsEnvironment();
		env.getDefaultScreenDevice();//RETURN graphicsDevice;
		
	}
	public static void main(String[] args) {
		new Screen();
	}
}

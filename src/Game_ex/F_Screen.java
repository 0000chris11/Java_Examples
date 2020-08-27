package Game_ex;

import java.awt.*;
import javax.swing.JFrame;

public class F_Screen {
	private GraphicsDevice gd;

	public F_Screen() {
		GraphicsEnvironment env = 
				GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = env.getDefaultScreenDevice();
	}

	public void setFullScreen(DisplayMode dm, JFrame window) {
		window.setUndecorated(true);
		window.setResizable(false);
		
		//Color c =new Color(1f,1f,1f,.0f );
		//window.setBackground(c);
		gd.setFullScreenWindow(window);
		
		
		if(dm != null && gd.isDisplayChangeSupported())
			try {
				gd.setDisplayMode(dm);
			}catch(Exception e) {}
	}
	public Window getFullScreenWindow() {
		return gd.getFullScreenWindow();
	}
	public void restorScreen() {
		Window w = gd.getFullScreenWindow();
		if(w != null) {
			w.dispose();
		}
		gd.setFullScreenWindow(null);
	}

}

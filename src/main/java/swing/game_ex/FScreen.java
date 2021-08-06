package swing.game_ex;

import java.awt.*;
import javax.swing.JFrame;

public class FScreen {

	private GraphicsDevice graphicsDevice;
	//--------------------------------------------
	FScreen() {
		GraphicsEnvironment env = 
				GraphicsEnvironment.getLocalGraphicsEnvironment();
		graphicsDevice = env.getDefaultScreenDevice();
	}
	//--------------------------------------------
	void setFullScreen(DisplayMode displayMode, JFrame window) {
		window.setUndecorated(true);
		window.setResizable(false);
		
		//Color c =new Color(1f,1f,1f,.0f );
		//window.setBackground(c);
		graphicsDevice.setFullScreenWindow(window);
		
		
		if(displayMode != null && graphicsDevice.isDisplayChangeSupported())
			try {
				graphicsDevice.setDisplayMode(displayMode);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	Window getFullScreenWindow() {
		return graphicsDevice.getFullScreenWindow();
	}
	
	void restorScreen() {
		Window w = graphicsDevice.getFullScreenWindow();
		if(w != null) {
			w.dispose();
		}
		graphicsDevice.setFullScreenWindow(null);
	}

}

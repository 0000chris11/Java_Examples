package swing.game_ex;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Head extends JFrame{

	public static void main(String[] args) {
		//Invalid display mode
		DisplayMode displayMode = new 
				DisplayMode(800,600,16,DisplayMode.REFRESH_RATE_UNKNOWN);
		Head h = new Head();
		h.run(displayMode);
	}
	//---------------------------------------------------------------------------
	private transient Image bgImage;
	private transient Image pic;
	private boolean loaded;
	
	void run(DisplayMode displayMode) {
		setFont(new Font("Arial",Font.PLAIN,24));
		loaded = false;
		
		FScreen fScreen = new FScreen();
		try {
			fScreen.setFullScreen(displayMode, this);
			loadPic();
			try {
				Thread.sleep(5000);
			}catch(Exception e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
		finally {
			fScreen.restorScreen();
		}
	}//---------------------------------------------------------------------------
	void loadPic() {
		//UPDATE URLS LOCATIONS!!!!!!!!!!1
		bgImage = new ImageIcon(getClass().getResource("/black_bg2.jpg")).getImage();
		pic = new ImageIcon(getClass().getResource("/c1.jpg")).getImage();
		//gif = new Icon(new ImageIcon(ImageIO.read(getClass().getResource("/RS.gif"))).getImage();
		loaded = true;
		repaint();
		
	}
	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		if(g instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		if(loaded) {
			g.drawImage(bgImage,0,0,null);
			g.drawImage(pic, 300, 300, null);
			//g.drawImage(gif,400,200,null);
			g.drawString("HEY", 200, 200);
			g.setColor(Color.BLUE);
			g.fillRect(50, 50, 100, 50);
		}
	}
}

package Game_ex;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Head extends JFrame{
	public static void main(String[] args) {
		DisplayMode dm = new 
				DisplayMode(800,600,16,DisplayMode.REFRESH_RATE_UNKNOWN);
		Head h = new Head();
		h.run(dm);
	}//---------------------------------------------------------------------------
	private F_Screen s;
	private Image bg;
	private Image pic;
	private Icon gif;
	private boolean loaded;
	
	public void run(DisplayMode d) {
		//getContentPane().setBackground(null);
		//getContentPane().setForeground(Color.BLUE);
		setFont(new Font("Arial",Font.PLAIN,24));
		loaded = false;
		
		s = new F_Screen();
		try {
			s.setFullScreen(d, this);
			loadPic();
			try {
				Thread.sleep(5000);
			}catch(Exception e) {}
		}
		finally {
			s.restorScreen();
		}
	}//---------------------------------------------------------------------------
	public void loadPic() {
		bg = new ImageIcon(getClass().getResource("/black_bg2.jpg")).getImage();
		pic = new ImageIcon(getClass().getResource("/c1.jpg")).getImage();
		//gif = new Icon(new ImageIcon(ImageIO.read(getClass().getResource("/RS.gif"))).getImage();
		loaded = true;
		repaint();
		
	}
	public void paint(Graphics g) {
		//super.paint(g);
		if(g instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		if(loaded) {
			g.drawImage(bg,0,0,null);
			g.drawImage(pic, 300, 300, null);
			//g.drawImage(gif,400,200,null);
			g.drawString("HEY", 200, 200);
			g.setColor(Color.BLUE);
			g.fillRect(50, 50, 100, 50);
		}
		
		
		
	}
	

}

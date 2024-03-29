package swing.game_ex;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Character {

	private String characterPath = "RS.gif";
	private int dx;
	private int dy;
	private int x;
	private int y;
	
	private Image image;
	//--------------------------------------
	public Character() {
		x=40;
		y=40;
		ImageIcon img = new ImageIcon(getClass().getResource(characterPath));
		image = img.getImage();
	}
	//CONTROL--------------------------------------
	public void move() {
		x += dx;
		y += dy;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Image getImage() {
		return image;
	}
	//LISTENERS-------------------------------
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key==KeyEvent.VK_LEFT) {
			dx= -2;
		}
		if(key==KeyEvent.VK_RIGHT) {
			dx= 2;
		}
		if(key==KeyEvent.VK_UP) {
			dy= -2;
		}
		if(key==KeyEvent.VK_DOWN) {
			dy= 2;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key==KeyEvent.VK_LEFT) {
			dx= 0;
		}
		if(key==KeyEvent.VK_RIGHT) {
			dx= 0;
		}
		if(key==KeyEvent.VK_UP) {
			dy= 0;
		}
		if(key==KeyEvent.VK_DOWN) {
			dy= 0;
		}
	}
}

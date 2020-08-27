package Game_ex;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Draw extends JPanel implements ActionListener{
	private Character ch;
	private Timer timer;
	public Draw() {
		setBackground(Color.WHITE);
		setFocusable(true);
		addKeyListener(new keyboard());
		
		ch = new Character();
		timer = new Timer(15,this);
		timer.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(ch.getImage(),ch.getX(),ch.getY(),null);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		ch.move();
		repaint();
	}
	private class keyboard extends KeyAdapter{
		public void keyReleased(KeyEvent e) {
			ch.keyReleased(e);
		}
		public void keyPressed(KeyEvent e) {
			ch.keyPressed(e);
		}
	}
}

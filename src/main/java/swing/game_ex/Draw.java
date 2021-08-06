package swing.game_ex;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import javax.swing.JPanel;

public class Draw extends JPanel implements ActionListener {

	private transient Character character;
	private Timer timer;

	// ---------------------------------------------
	Draw() {
		setBackground(Color.WHITE);
		setFocusable(true);
		addKeyListener(new Keyboard());

		character = new Character();
		timer = new Timer(15, this);
		timer.start();
	}

	// ---------------------------------------------
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(character.getImage(), character.getX(), character.getY(), null);

	}

	// LISTENERS----------------------------------
	public void actionPerformed(ActionEvent arg0) {
		character.move();
		repaint();
	}

	// INNER-CLASS---------------------------------
	private class Keyboard extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			character.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			character.keyPressed(e);
		}
	}
}

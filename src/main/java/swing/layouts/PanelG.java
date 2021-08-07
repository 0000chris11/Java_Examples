/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.layouts;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author C0FII
 */
public class PanelG extends JPanel {

      
      @Override
      public void paintComponent(Graphics g) {
            //System.out.println(">>>>>paintComponents");
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(
                    new GradientPaint(
                            0, 0, Color.BLACK, getWidth(), getHeight(),
                            new Color(0, 204, 204)));
            g2.fillRect(0, 0, getWidth(), getHeight());

            super.paintComponents(g);
      }
      

      PanelG() {
            setBackground(Color.LIGHT_GRAY);
      }
}

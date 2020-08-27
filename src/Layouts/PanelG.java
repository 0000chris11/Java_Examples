/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Christopher
 */
public class PanelG extends JPanel {

      @Override
      public void paintComponent(Graphics g) {
            System.out.println(">>>>>paintComponents");
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(
                    new GradientPaint(
                            0, 0, Color.BLACK, getWidth(), getHeight(),
                            new Color(0, 204, 204)));
            g2.fillRect(0, 0, getWidth(), getHeight());

            super.paintComponents(g);
      }

      public PanelG(String layout) {
            if (layout == null) {
                  setLayout(null);
            }else if(layout.equalsIgnoreCase("miglayout")){
                  setLayout(new MigLayout());
            }else if(layout.equalsIgnoreCase("boxlayout")){
                  setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            }
            setSize(300,300);
            setBackground(Color.BLACK);
      }
}

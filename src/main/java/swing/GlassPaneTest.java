/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import com.cofii2.methods.MComp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author C0FII
 */
public class GlassPaneTest {

      private JFrame JF = new JFrame();
      private JPanel JP1 = new JPanel();
      private JPanel JP2 = new JPanel();
      JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                  if(visible){
                        Graphics2D g2 = (Graphics2D) g;
                        g2.setColor(Color.WHITE);
                        g2.drawLine(2, this.getHeight() / 2, this.getWidth() - 4, this.getHeight() / 2);
                  }
            }
      };

      private JButton btn_action = new JButton("ACTION");
      private boolean visible = false;

      public GlassPaneTest() {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setGlassPane(panel);
            JF.getContentPane().setLayout(new BorderLayout(1, 1));
            JF.getContentPane().add(JP1, BorderLayout.CENTER);
            JF.getContentPane().add(JP2, BorderLayout.EAST);

            JP1.setBackground(Color.BLUE.darker());
            JP2.setBackground(Color.RED.darker());

            JP1.setMinimumSize(new Dimension(100, 100));
            JP1.setMaximumSize(new Dimension(600, Short.MAX_VALUE));
            JP1.setPreferredSize(new Dimension(400, 400));
            JP2.setMinimumSize(new Dimension(100, 100));
            JP2.setMaximumSize(new Dimension(600, Short.MAX_VALUE));
            JP2.setPreferredSize(new Dimension(400, 400));

            JP1.setLayout(null);
            JP1.add(btn_action);
            btn_action.setBounds(20, 20, 200, 27);
            
            btn_action.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        visible = true;
                  }

            });
            //System.out.println("GLASS PANE: " + JF.getGlassPane().getClass().toString());

      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        GlassPaneTest tt = new GlassPaneTest();
                        tt.JF.setSize(new Dimension(800, 400));
                        MComp.setFrameToCenterOfScreen(tt.JF);
                        tt.JF.setVisible(true);
                  }

            });
      }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package String;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 *
 * @author C0FII
 */
public class VT {

      JFrame JF = new JFrame();
      JButton[] btns = new JButton[]{
            new JButton("add Shape"), new JButton("getBorder"), 
            new JButton("setBorder")};

      public VT() {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.X_AXIS));
            JF.setVisible(true);
            for (int a = 0; a < btns.length; a++) {
                  JF.add(btns[a]);
                  btns[a].addActionListener(new Action());
            }

            JF.pack();
            JF.setSize(JF.getWidth() + 100, JF.getHeight());
      }

      class Action implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                  String ac = e.getActionCommand();
                  if (ac.equals(btns[0].getText())) {
                        System.out.println("\n" + btns[0].getText());
                        JPanel JP2 = FontMetrics_ex.JP2;
                        Graphics2D g2 = (Graphics2D) JP2.getGraphics();
                        System.out.println("\tgraphics: " + g2);
                        System.out.println("\tshape 0: " + FontMetrics_ex.listS.get(1).getClass());
                        System.out.println("\t\tcurrent color: "
                                + g2.getColor().getRed() + ", "
                                + g2.getColor().getGreen() + ", "
                                + g2.getColor().getBlue());

                        g2.setColor(Color.WHITE);
                        System.out.println("\t\tcurrent color: "
                                + g2.getColor().getRed() + ", "
                                + g2.getColor().getGreen() + ", "
                                + g2.getColor().getBlue());
                        g2.translate(100, 100);
                        g2.draw(FontMetrics_ex.listS.get(1));
                  } else if (ac.equals(btns[1].getText())) {
                        System.out.println("\n" + btns[1].getText());
                        System.out.println("\t" + FontMetrics_ex.JBTN.getBorder());
                  } else if (ac.equals(btns[2].getText())) {
                        System.out.println("\n" + btns[2].getText());
                        FontMetrics_ex.JBTN.setBorder(
                                BorderFactory.createBevelBorder(BevelBorder.LOWERED));
                        //FontMetrics_ex.JP.add();
                  }
            }

      }
}

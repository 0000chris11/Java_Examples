/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Christopher
 */
public class Second {

      JFrame JF = new JFrame();

      JLabel lb = new JLabel("NEW LABEL");

      JButton[] btns = new JButton[]{
            new JButton("P1 Call PC"),
            new JButton("P2 Call PC"),
            new JButton("P3 Call PC"),
            new JButton("P1 GetComponents"),
            new JButton("P2 GetComponents"),
            new JButton("P3 GetComponents"),
            new JButton("P1 add PreButton"),
            new JButton("P2 add PreButton"),
            new JButton("P3 add PreButton")};

      int count = 0;

      public Second() {
            JF.setTitle("Configuration");
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setAlwaysOnTop(true);
            JF.setTitle("Test Window");

            JF.setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.PAGE_AXIS));
            for (int a = 0; a < btns.length; a++) {
                  JF.add(btns[a]);
            }
            BTNSActionCP A_CP = new BTNSActionCP();
            BTNSActionGC A_GC = new BTNSActionGC();
            BTNSActionAC A_AC = new BTNSActionAC();
            btns[0].addActionListener(A_CP);
            btns[1].addActionListener(A_CP);
            btns[2].addActionListener(A_CP);
            btns[3].addActionListener(A_GC);
            btns[4].addActionListener(A_GC);
            btns[5].addActionListener(A_GC);
            btns[6].addActionListener(A_AC);
            btns[7].addActionListener(A_AC);
            btns[8].addActionListener(A_AC);
            //+++++++++++++++++++++++++++++++++++++
            lb.setLocation(6, 100);
            lb.setSize(200, 100);
            lb.setFont(new Font("Dialog", Font.PLAIN, 24));
            lb.setForeground(Color.WHITE);
            lb.setName("LB_U");

            JF.pack();
            JF.setSize(JF.getWidth() + 60, JF.getHeight());
            JF.setVisible(true);
      }

      private class BTNSActionCP implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent evt) {
                  String ac = evt.getActionCommand();
                  if (ac.equals(btns[0].getText())) {
                        System.out.println("\n" + btns[0].getText());
                        Main.JPS[0].paintComponents(Main.JPS[0].getGraphics());
                  } else if (ac.equals(btns[1].getText())) {
                        System.out.println("\n" + btns[1].getText());
                        Main.JPS[1].paintComponents(Main.JPS[1].getGraphics());
                  } else if (ac.equals(btns[2].getText())) {
                        System.out.println("\n" + btns[2].getText());
                        Main.JPS[2].paintComponents(Main.JPS[2].getGraphics());
                  }
            }

      }

      private class BTNSActionGC implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                  String ac = e.getActionCommand();
                  if (ac.equals(btns[3].getText())) {
                        System.out.println("\n" + btns[3].getText());
                        if (Main.JPS[0].getComponentCount() == 0) {
                              System.out.println("\tEmpy Panel");
                        } else {
                              for (int a = 0; a < Main.JPS[0].getComponentCount(); a++) {
                                    JComponent jc = (JComponent) Main.JPS[0].getComponent(a);

                                    System.out.println("\t" + a + ": "
                                            + jc.getName()
                                            + " (" + jc.getLayout() + ")");
                              }
                        }
                  } else if (ac.equals(btns[4].getText())) {
                        System.out.println("\n" + btns[4].getText());
                        if (Main.JPS[1].getComponentCount() == 0) {
                              System.out.println("\tEmpy Panel");
                        } else {
                              for (int a = 0; a < Main.JPS[1].getComponentCount(); a++) {
                                    JComponent jc = (JComponent) Main.JPS[1].getComponent(a);

                                    System.out.println("\t" + a + ": "
                                            + jc.getName()
                                            + " (" + jc.getLayout() + ")");
                              }
                        }
                  } else if (ac.equals(btns[5].getText())) {
                        System.out.println("\n" + btns[5].getText());
                        if (Main.JPS[2].getComponentCount() == 0) {
                              System.out.println("\tEmpy Panel");
                        } else {
                              for (int a = 0; a < Main.JPS[2].getComponentCount(); a++) {
                                    JComponent jc = (JComponent) Main.JPS[2].getComponent(a);

                                    System.out.println("\t" + a + ": "
                                            + jc.getName()
                                            + " (" + jc.getLayout() + ")");
                              }
                        }
                  }
            }

      }

      private class BTNSActionAC implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                  String ac = e.getActionCommand();
                  if (ac.equals(btns[6].getText())) {
                        System.out.println("\n" + btns[6].getText());
                        Main.JPS[0].add(Main.JBTNS[0]);
                        Main.JPS[0].add(Main.JBTNS[1]);
                        Main.JPS[0].add(Main.JBTNS[2]);
                  } else if (ac.equals(btns[7].getText())) {
                        System.out.println("\n" + btns[7].getText());
                        Main.JPS[1].add(Main.JBTNS[0]);
                        Main.JPS[1].add(Main.JBTNS[1]);
                        Main.JPS[1].add(Main.JBTNS[2]);
                  } else if (ac.equals(btns[8].getText())) {
                        System.out.println("\n" + btns[8].getText());
                        Main.JPS[2].add(Main.JBTNS[0]);
                        Main.JPS[2].add(Main.JBTNS[1]);
                        Main.JPS[2].add(Main.JBTNS[2]);
                  }
                  Main.JPS[0].repaint();
                  Main.JPS[1].repaint();
                  Main.JPS[2].repaint();
            }

      }
}

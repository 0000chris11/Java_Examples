package Layouts;

import AAMethods.MM;
import Test_Window.VT;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Christopher
 */
public class Main {

      JFrame JF = new JFrame();
      JPanel JP = new JPanel();
      JScrollPane SC = new JScrollPane(JP);

      static String[] txs = new String[]{
            "NULL",
            "BorderLayout",
            "BoxLayout",
            "CardLayout",
            "FlowLayout",
            "GridBagLayout",
            "GridLayout",
            "GroupLayout",
            "MigLayout",
            "OverLayout",
            "SpringLayout"};

      static JPanel[] JPS = new JPanel[txs.length];

      private void setPanelsLayouts() {
            for (int a = 0; a < JPS.length; a++) {
                  JPS[a] = new JPanel();
                  JPS[a].setBackground(Color.BLACK);
                  JPS[a].setToolTipText(txs[a]);
            }

            JPS[0].setLayout(null);
            JPS[1].setLayout(new BorderLayout(2, 2));
            JPS[2].setLayout(new BoxLayout(JPS[2], BoxLayout.Y_AXIS));
            JPS[3].setLayout(new CardLayout(2, 2));
            JPS[4].setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
            JPS[5].setLayout(new GridBagLayout());
            JPS[6].setLayout(new GridLayout(2, 2));
            JPS[7].setLayout(new GroupLayout(JPS[7]));
            JPS[8].setLayout(new MigLayout());
            JPS[9].setLayout(new OverlayLayout(JPS[9]));
            JPS[10].setLayout(new SpringLayout());
      }

      private void testConfig() {
            VT vt = new VT();
            vt.addComboBox(new JComboBox(txs));
            vt.addButton(new JButton("ADD"));
            vt.addButton(new JButton("REPAINT"));
            vt.addButton(new JButton("COMPONENTS"));
            vt.addButton(new JButton("LAYOUT"));
            vt.addSeparator(new JSeparator(JSeparator.VERTICAL));
            vt.setVisible(true);

            ActionListener al = new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.out.println("LISTEN!");

                        for (int a = 0; a < txs.length; a++) {
                              String item = vt.getCBOXS().get(0).getSelectedItem().toString();
                              if (item.equals(txs[a])) {
                                    if (e.getActionCommand().equals("ADD")) {
                                          System.out.println("\t" + txs[a] + ": button added");
                                          JButton btn = new JButton("H");
                                          //btn.setBounds(0, 0, 60, 30);
                                          btn.setSize(60, 30);
                                          JPS[a].add(btn);
                                          JPS[a].repaint();
                                    } else if (e.getActionCommand().equals("REPAINT")) {
                                          System.out.println("\t" + txs[a] + ": repainting");
                                          JPS[a].repaint();
                                    } else if (e.getActionCommand().equals("COMPONENTS")) {
                                          System.out.println("\t" + txs[a]);
                                          int count = JPS[a].getComponentCount();
                                          if (count == 0) {
                                                System.out.println("\t\tNO COMPONENTS");
                                          } else {
                                                for (int b = 0; b < count; b++) {
                                                      System.out.println("\t\t" + (b + 1) + ": "
                                                              + JPS[a].getComponent(b).getClass().toString());
                                                }
                                          }
                                    } else if (e.getActionCommand().equals("LAYOUT")) {
                                          try {
                                                System.out.println("\t" + txs[a] + ": " + JPS[a].getLayout().toString());
                                          } catch (NullPointerException ex) {
                                                System.out.println("\t" + txs[a] + ": NULL LAYOUT");
                                          }
                                    }
                              }
                        }

                  }

            }
            vt.getBTNS().get(0).addActionListener(al);
            vt.getBTNS().get(1).addActionListener(al);
            vt.getBTNS().get(2).addActionListener(al);
            vt.getBTNS().get(3).addActionListener(al);
      }

      public void setName(JComponent jc, String name) {
            jc.setName(name);
      }

      public Main() {
            JF.setTitle("Layout Test");
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setAlwaysOnTop(true);
            //JF.setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.X_AXIS));
            JF.setLocationRelativeTo(null);
            JF.setLayout(new GridLayout(1,1,2,2));
            JF.setSize(1200, 600);
            //int d = 2;
            int sX = 0;
            int bs = 4;
            JF.add(SC);
            JP.setLayout(new GridLayout(2, 5, 2, 2));

            MM.setComponentFitOnJFrame(SC, JF);
            JP.setSize(SC.getSize());
            setPanelsLayouts();
            for (int a = 0; a < JPS.length; a++) {
                  setName(JPS[a], ("JP_" + (a + 1)));
                  JP.add(JPS[a]);
            }
            testConfig();
            //+++++++++++++++++++++++
            JF.setVisible(true);
      }

      public static void main(String[] args) {
            new Main();
            //new Second();
      }
}

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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Christopher
 */
public class MainLayouts {

      JFrame JF = new JFrame();
      JPanel JP = new JPanel();
      JScrollPane SC = new JScrollPane(JP);

      String[] comps;
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

      //+++++++++++++++++++++++++++++++++++
      private void cardLayoutConfig(JComponent JPS) {

      }

      private void groupLayoutConfig(JComponent JPS) {
            GroupLayout groupl = new GroupLayout(JPS);
            JPS.setLayout(groupl);
            groupl.setAutoCreateGaps(true);
            groupl.setAutoCreateContainerGaps(true);

            JButton btn1 = new JButton("B1");
            JButton btn2 = new JButton("B2");
            JButton btn3 = new JButton("B3");
            JButton btn4 = new JButton("B4");
            //++++++++++++++++++++++++++++++++++
            //++++++++++++++++++++++++++++++++++
            SequentialGroup sh = groupl.createSequentialGroup();
            ParallelGroup ph = groupl.createParallelGroup(GroupLayout.Alignment.LEADING);
            groupl.setHorizontalGroup(sh);
            sh.addComponent(DATA.lbs[0]);
            sh.addComponent(DATA.lbs[1]);
            sh.addGroup(ph);
            ph.addComponent(DATA.lbs[2]);
            ph.addComponent(DATA.lsts[2]);
            ph.addComponent(DATA.btns[2]);
            //++++++++++++++++++++++++++++++++++
            //++++++++++++++++++++++++++++++++++
            SequentialGroup sv = groupl.createSequentialGroup();
            groupl.setVerticalGroup(sv);
            //++++++++++++++++++++++++++++++++++
            ParallelGroup pv = groupl.createParallelGroup(GroupLayout.Alignment.BASELINE);
            sv.addGroup(pv);
            pv.addComponent(DATA.lbs[0]);
            pv.addComponent(DATA.lbs[1]);
            pv.addComponent(DATA.lbs[2]);
            //++++++++++++++++++++++++++++++++++
            sv.addComponent(DATA.lsts[2]);
            sv.addComponent(DATA.btns[2]);

      }

      private void setPanelsLayouts() {
            MouseListener ml = new MouseListener() {
                  @Override
                  public void mouseClicked(MouseEvent e) {

                  }

                  @Override
                  public void mousePressed(MouseEvent e) {
                        System.out.println("LISTEN!");
                        if (e.getButton() == 3) {
                              for (int a = 0; a < JPS.length; a++) {
                                    if (e.getComponent() == JPS[a]) {
                                          //System.out.println("\t" + txs[a]);
                                          System.out.println("\t" + JPS[a].getMousePosition());
                                          JButton btn = new JButton("M");
                                          //btn.setBounds(0, 0, 60, 30);
                                          btn.setLocation(JPS[a].getMousePosition());
                                          btn.setSize(60, 30);
                                          JPS[a].add(btn);
                                          JPS[a].repaint();
                                    }
                              }
                        }
                  }

                  @Override
                  public void mouseReleased(MouseEvent e) {

                  }

                  @Override
                  public void mouseEntered(MouseEvent e) {

                  }

                  @Override
                  public void mouseExited(MouseEvent e) {

                  }

            };
            for (int a = 0; a < JPS.length; a++) {
                  JPS[a] = new JPanel();
                  JPS[a].setBackground(Color.BLACK);
                  JPS[a].setToolTipText(txs[a]);
                  JPS[a].addMouseListener(ml);
            }

            JPS[0].setLayout(null);
            JPS[1].setLayout(new BorderLayout(2, 2));
            JPS[2].setLayout(new BoxLayout(JPS[2], BoxLayout.Y_AXIS));
            JPS[3].setLayout(new CardLayout(2, 2));
            JPS[4].setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
            JPS[5].setLayout(new GridBagLayout());
            JPS[6].setLayout(new GridLayout(2, 2));
            groupLayoutConfig(JPS[7]);
            JPS[8].setLayout(new MigLayout());
            JPS[9].setLayout(new OverlayLayout(JPS[9]));
            JPS[10].setLayout(new SpringLayout());
      }

      //+++++++++++++++++++++++++++++++++++
      private void VTConfig() {
            VT vt = new VT();
            vt.addComboBox(new JComboBox(txs));
            vt.addButton(new JButton("ADD"));
            vt.addButton(new JButton("REPAINT"));
            vt.addButton(new JButton("COMPONENTS"));
            vt.addButton(new JButton("LAYOUT"));
            vt.addSeparator(new JSeparator(JSeparator.VERTICAL));
            vt.setVisible(true);
            vt.setAlwaysOnTop(true);

            ItemListener il = new ItemListener() {
                  @Override
                  public void itemStateChanged(ItemEvent e) {
                        CardLayout cl = (CardLayout) JP.getLayout();
                        cl.show(JP, vt.getCBOXS().get(0).getSelectedItem().toString());
                  }

            };
            vt.getCBOXS().get(0).addItemListener(il);

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

            };
            vt.getBTNS().get(0).addActionListener(al);
            vt.getBTNS().get(1).addActionListener(al);
            vt.getBTNS().get(2).addActionListener(al);
            vt.getBTNS().get(3).addActionListener(al);
      }
      
      private void VT2Config(){
            VT vt2 = new VT();
            vt2.addComboBox(new JComboBox(comps));
      }

      private void setName(JComponent jc, String name) {
            jc.setName(name);
      }

      private void setDATAComponents() {
            String[] listT = new String[5];
            for (int a = 0; a < 10; a++) {
                  DATA.lbs[a] = new JLabel("LB_" + (a + 1));
                  DATA.lbs[a].setName("LB_" + (a + 1));
                  DATA.lbs[a].setForeground(Color.WHITE);
                  
                  DATA.tfs[a] = new JTextField("TF_" + (a + 1));
                  DATA.tfs[a].setName("TF_" + (a + 1));
                  
                  for(int b = 0; b < 5; b++){
                        listT[b] = "Element " + (b + 1);
                  }
                  DATA.lsts[a] = new JList(listT);
                  DATA.lsts[a].setName("LIST_" + (a + 1));
                  
                  DATA.btns[a] = new JButton("BTN_" + (a + 1));
                  DATA.btns[a].setName("BTN_" + (a + 1));
            }
            setComponentsToString();
      }
      private void setComponentsToString(){
            ArrayList<String> list = new ArrayList<String>();
            for(int a = 0; a < 10; a++){
                  list.add(DATA.lbs[a].getName());
                  list.add(DATA.tfs[a].getName());
                  list.add(DATA.lsts[a].getName());
                  list.add(DATA.btns[a].getName());
            }
            comps = (String[]) list.toArray();
      }

      public MainLayouts() {
            JF.setTitle("Layout Test");
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setAlwaysOnTop(true);
            //JF.setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.X_AXIS));
            JF.setLocationRelativeTo(null);
            JF.setLayout(new GridLayout(1, 1, 2, 2));
            JF.setSize(1200, 600);
            setDATAComponents();
            //JF.add(SC);
            //JP.setLayout(new GridLayout(2, 5, 2, 2));
            JF.add(SC);
            JP.setLayout(new CardLayout(2, 2));
            MM.setComponentFitOnJFrame(SC, JF);
            JP.setSize(SC.getSize());

            setPanelsLayouts();
            for (int a = 0; a < JPS.length; a++) {
                  setName(JPS[a], ("JP_" + (a + 1)));
                  JP.add(JPS[a], txs[a]);
            }
            VTConfig();
            //+++++++++++++++++++++++
            JF.setVisible(true);
      }

      public static void main(String[] args) {
            new MainLayouts();
            //new Second();
      }
}

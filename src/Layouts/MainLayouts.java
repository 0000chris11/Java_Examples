package Layouts;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.OverlayLayout;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;

import AAMethods.MM;
import net.miginfocom.swing.MigLayout;

import com.cofii.myClasses.VT;
/**
 *
 * @author Christopher
 */
public class MainLayouts {

      VT vtM = new VT();
      VT vtGL = new VT();
      int c1i = 0;
      VT vtGBL = new VT();

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
            //FOR LATER
      }

      private void groupLayoutMain(JComponent JPS) {
            GroupLayout groupl = new GroupLayout(JPS);
            JPS.setLayout(groupl);

            //groupLayoutFirstEX(groupl);
            groupLayoutEXH2(groupl, 3);
      }

      private void groupLayoutFirstEX(GroupLayout layout) {
            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);
            layout.setHonorsVisibility(true);
            //++++++++++++++++++++++++++++++++++
            int gw = DATA.lbs[0].getPreferredSize().width;

            //++++++++++++++++++++++++++++++++++
            SequentialGroup sh = layout.createSequentialGroup();
            SequentialGroup sv = layout.createSequentialGroup();

            layout.setHorizontalGroup(sh);
            layout.setVerticalGroup(sv);

            ParallelGroup ph1 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
            ParallelGroup ph2 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
            ParallelGroup ph3 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
            ParallelGroup ph4 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
            //+++++++++++++++++++++++++++++++++++++++++
            int limit = 3;
            sh.addGroup(ph1);
            for (int a = 0; a < limit; a++) {
                  ph1.addComponent(DATA.lbs[a]);
                  ph1.addGap(gw);
            }
            sh.addGroup(ph2);
            for (int a = 0; a < limit; a++) {
                  ph2.addComponent(DATA.tfs[a], 20, 90, 220);
                  ph2.addComponent(DATA.lsts[a], 60, 150, 300);
            }
            sh.addGroup(ph3);
            for (int a = 0; a < limit; a++) {
                  ph3.addComponent(DATA.cbs[a], 40, 40, 40);
                  ph3.addGap(gw);
            }

            sh.addGroup(ph4);
            for (int a = 0; a < limit; a++) {
                  ph4.addComponent(DATA.btns[a]);
                  ph4.addGap(gw);
            }

            for (int a = 0; a < limit; a++) {
                  ParallelGroup pv1 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
                  sv.addGroup(pv1);

                  pv1.addComponent(DATA.lbs[a]);
                  pv1.addComponent(DATA.tfs[a]);
                  pv1.addComponent(DATA.cbs[a]);
                  pv1.addComponent(DATA.btns[a]);

                  ParallelGroup pv2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
                  sv.addGroup(pv2);

                  pv2.addGap(0);
                  pv2.addComponent(DATA.lsts[a]);
                  pv2.addGap(0);
                  pv2.addGap(0);
            }
      }

      private void groupLayoutConfigH(GroupLayout layout) {
            //HORIZONTAL GROUP (ParallelGroup)
            //1 Group (SequentialGroup)
            //1.1 Container Gap
            //1.2 Group (ParallelGroup false)
            //1.2.1 Group (SequentialGroup)
            //1.2.1.1 LB [0]
            //1.2.1.2 PREF GAP (RELATED)
            //1.2.1.3 Group (ParallelGroup false)
            //1.2.1.3.1 Group (Sequential)
            //1.2.1.3.1.1 TF [0] (PREF, 100, PREF)
            //1.2.1.3.1.2 PREF GAP (RELATED)
            //1.2.1.3.1.3 CB [0] (PREF, DEF, PREF)
            //1.2.1.3.2 LST [0]
            //1.2.2 Group (Sequential)
            //1.2.2.1 LB [1]
            //1.2.2.2 PREF GAP (RELATED)
            //1.2.2.3 TF [1]
            //1.2.2.4 PREF GAP (RELATED)
            //1.2.2.5 CB [1] (PREF, DEF, PREF)
            //1.3 PREF GAP (RELATED)
            //1.4 Group (Parallel LEADING)
            //1.4.1 BTN [0]
            //1.4.2 BTN [1]
            //1.5 Container Gap (106, Shor-MAX)

            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(DATA.lbs[0])
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(DATA.tfs[0], GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(DATA.cbs[0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(DATA.lsts[0])))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(DATA.lbs[0])
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(DATA.tfs[1])
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(DATA.cbs[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(DATA.btns[0])
                                            .addComponent(DATA.btns[1]))
                                    .addContainerGap(106, Short.MAX_VALUE))
            );
      }

      private void groupLayoutEX_H(GroupLayout layout) {
            //VERTICAL GROUP (Parallel LEADING)

            int LST_PREF = 200;
            int TF_PREF = 150;
            int CB_PREF = 50;
            layout.setAutoCreateGaps(true);

            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                                            .addComponent(DATA.lbs[0])
                                            .addGap(0)
                                            .addComponent(DATA.lbs[1]))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(DATA.tfs[0], TF_PREF, TF_PREF, Short.MAX_VALUE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(DATA.cbs[0], CB_PREF, CB_PREF, CB_PREF))
                                            .addComponent(DATA.lsts[0], LST_PREF, LST_PREF, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(DATA.tfs[1], TF_PREF, TF_PREF, Short.MAX_VALUE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(DATA.cbs[1], CB_PREF, CB_PREF, CB_PREF)))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                                            .addComponent(DATA.btns[0])
                                            .addGap(0)
                                            .addComponent(DATA.btns[1]))));

            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(DATA.lbs[0])
                                            .addComponent(DATA.tfs[0])
                                            .addComponent(DATA.cbs[0])
                                            .addComponent(DATA.btns[0]))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(DATA.lsts[0])
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(DATA.lbs[1])
                                            .addComponent(DATA.tfs[1])
                                            .addComponent(DATA.cbs[1])
                                            .addComponent(DATA.btns[1]))));
      }

      private void groupLayoutEXH2(GroupLayout gl, int limit) {
            gl.setAutoCreateGaps(true);
            gl.setAutoCreateContainerGaps(true);

            ParallelGroup pgh1 = gl.createParallelGroup(GroupLayout.Alignment.LEADING, true);
            ParallelGroup pgh2 = gl.createParallelGroup(GroupLayout.Alignment.LEADING, true);
            ParallelGroup pgh3 = gl.createParallelGroup(GroupLayout.Alignment.LEADING, true);

            SequentialGroup sgv1 = gl.createSequentialGroup();
            int LST_PREF = 200;
            int TF_PREF = 150;
            int CON_PREF = 50;

            for (int a = 0; a < limit; a++) {
                  pgh1.addComponent(DATA.lbs[a]);
                  pgh1.addGap(0);
                  //++++++++++++++++++++++++++
                  pgh2.addGroup(gl.createSequentialGroup()
                          .addComponent(DATA.tfs[a], TF_PREF, TF_PREF, Short.MAX_VALUE)
                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(DATA.cbs[a], CON_PREF, CON_PREF, CON_PREF));
                  pgh2.addComponent(DATA.lsts[a], LST_PREF, LST_PREF, Short.MAX_VALUE);
                  //++++++++++++++++++++++++++
                  pgh3.addComponent(DATA.btns[a]);
                  pgh3.addGap(0);
                  //=========================================
                  sgv1.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                          .addComponent(DATA.lbs[a])
                          .addComponent(DATA.tfs[a])
                          .addComponent(DATA.cbs[a])
                          .addComponent(DATA.btns[a]));
                  sgv1.addComponent(DATA.lsts[a]);
            }
            //++++++++++++++++++++++++++++++++
            //++++++++++++++++++++++++++++++++
            gl.setHorizontalGroup(
                    gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl.createSequentialGroup()
                                    .addGroup(pgh1)
                                    .addGroup(pgh2)
                                    .addGroup(pgh3)));

            gl.setVerticalGroup(
                    gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(sgv1));
            
            
      }

      private void gridBagLayout(JComponent JPS) {
            GridBagLayout gbl = new GridBagLayout();
            JPS.setLayout(gbl);
            GridBagConstraints c = new GridBagConstraints();

            for (int a = 0; a < 2; a++) {
                  c.fill = GridBagConstraints.HORIZONTAL;
                  c.weightx = 1;
                  c.weighty = 1;
                  c.gridx = a;
                  c.gridy = 0;
                  c.anchor = GridBagConstraints.FIRST_LINE_START;

                  JPS.add(new JButton("Button " + (a + 1)), c);
            }
            c.fill = GridBagConstraints.HORIZONTAL;
            c.ipady = 40;      //make this component tall
            c.weightx = 0.0;
            c.gridwidth = 3;
            c.gridx = 0;
            c.gridy = 1;
            JPS.add(new JButton("Button 4"), c);
      }

      private void setPanelsLayouts() {
            MouseListener ml = new MouseListener() {
                  @Override
                  public void mouseClicked(MouseEvent e) {
                        throw new UnsupportedOperationException();
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
            gridBagLayout(JPS[5]);
            JPS[6].setLayout(new GridLayout(2, 2));
            groupLayoutMain(JPS[7]);
            JPS[8].setLayout(new MigLayout());
            JPS[9].setLayout(new OverlayLayout(JPS[9]));
            JPS[10].setLayout(new SpringLayout());
      }

      //+++++++++++++++++++++++++++++++++++
      private void VTConfig() {
            JComboBox cb = new JComboBox(txs);
            JButton btn1 = new JButton("ADD");
            JButton btn2 = new JButton("REPAINT");
            JButton btn3 = new JButton("COMPONENTS");
            JButton btn4 = new JButton("LAYOUT");
            JSeparator sp = new JSeparator(JSeparator.VERTICAL);

            vtM.add(cb);
            vtM.add(btn1);
            vtM.add(btn2);
            vtM.add(btn3);
            vtM.add(btn4);
            vtM.add(sp);

            ItemListener il = new ItemListener() {
                  @Override
                  public void itemStateChanged(ItemEvent e) {
                        CardLayout cl = (CardLayout) JP.getLayout();
                        String selected = cb.getSelectedItem().toString();
                        cl.show(JP, selected);
                        //+++++++++++++++++++
                        //vtGL.dispose();
                        vtGBL.dispose();
                        if (selected.equals("GroupLayout")
                                && c1i == 0) {
                              c1i++;
                              VT_GLConfig();
                        } else if (selected.equals("GridBagLayout")) {
                              VT_GBLConfig(cb);
                        }
                  }

            };
            cb.addItemListener(il);

            ActionListener al = new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.out.println("LISTEN!");

                        for (int a = 0; a < txs.length; a++) {
                              String item = cb.getSelectedItem().toString();
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
            btn1.addActionListener(al);
            btn2.addActionListener(al);
            btn3.addActionListener(al);
            btn4.addActionListener(al);
            
            vtM.pack();
            vtM.setVisible(true);
            vtM.setAlwaysOnTop(true);
      }

      private void VT_GLConfig() {
            System.out.println("Creating VT_GLConfig");
            JComboBox cb = new JComboBox(comps);
            JToggleButton tg = new JToggleButton("VISIBLE");

            vtGL.add(cb);
            vtGL.add(tg);

            ItemListener il = new ItemListener() {
                  @Override
                  public void itemStateChanged(ItemEvent e) {
                        System.out.println("VISIBLE ?: " + txs.length);
                        //System.out.println("");
                        //System.out.println("\tComponents count: "
                        //      + JPS[a].getComponentCount());
                        //System.out.println("\tcomps lenght: " + comps.length);
                        for (int b = 0; b < JPS[7].getComponentCount(); b++) {
                              for (int c = 0; c < cb.getItemCount(); c++) {
                                    if (JPS[7].getComponent(b).getName().equals(
                                            cb.getSelectedItem().toString())) {
                                          System.out.println("\t\t"
                                                  + JPS[7].getComponent(b).getName());
                                          if (tg.isSelected()) {
                                                tg.setText("NOT VISIBLE");
                                                JPS[7].getComponent(b).setVisible(false);
                                          } else {
                                                tg.setText("VISIBLE");
                                                JPS[7].getComponent(b).setVisible(true);
                                          }
                                    }
                              }
                        }

                  }

            };
            tg.addItemListener(il);

            vtGL.pack();
            vtGL.setVisible(true);
            vtGL.setAlwaysOnTop(true);
      }

      private void VT_GBLConfig(JComboBox cb) {
            JButton btn = new JButton("getConstraints");
            vtGBL.add(btn);
            ActionListener al = new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        JPanel JP = JPS[cb.getSelectedIndex()];
                        for (int a = 0; a < JP.getComponentCount(); a++) {
                              GridBagLayout gbl = (GridBagLayout) JP.getLayout();
                              GridBagConstraints c = gbl.getConstraints(JP.getComponent(a));

                              System.out.println(((JButton) JP.getComponent(a)).getText());
                              System.out.println("\tanchor: " + c.anchor);
                              System.out.println("\tfill: " + c.fill);
                              System.out.println("\tgridheight: " + c.gridheight);
                              System.out.println("\tgridwidth: " + c.gridwidth);
                              System.out.println("\tgridx: " + c.gridx);
                              System.out.println("\tgridy: " + c.gridy);
                              System.out.println("\tinsets: " + c.insets);
                              System.out.println("\tipadx: " + c.ipadx);
                              System.out.println("\tipady: " + c.ipady);
                              System.out.println("\tweightx: " + c.weightx);
                              System.out.println("\tweighty: " + c.weighty);
                              //lookupConstraints()

                        }

                  }

            };
            btn.addActionListener(al);
            vtGBL.pack();
            vtGBL.setVisible(true);
            /*
            lb_Title.setBorder(new EmptyBorder(2, 4, 0, 0));
            Font F = UIManager.getFont("Label.font");
            lb_Title.setFont(new Font(F.getName(), F.getStyle(), F.getSize() + 6));
            lb_Title.setForeground(Color.WHITE);
            
            c.anchor = GridBagConstraints.PAGE_START;
            c.fill = GridBagConstraints.BOTH;
            //c.fill = GridBagConstraints.HORIZONTAL;
            c.ipady = 30;
            c.insets = new Insets(1, 2, 1, 1);
            c.gridx = 0;
            c.gridy = 0;
            c.gridheight = 4;
            c.weightx = 1;
            c.weighty = 0;
            JPN.add(lb_Title, c);

            jps[0] = new JPanel();
            jps[0].setBackground(Color.DARK_GRAY);
            jps[0].setName("Options Panel");
            c.anchor = GridBagConstraints.PAGE_START;
            c.fill = GridBagConstraints.BOTH;
            c.insets = new Insets(1, 2, 1, 1);
            c.gridx = 0;
            c.gridy = 4;
            c.weightx = 1;
            c.weighty = 1;
            JPN.add(jps[0], c);
             */
      }

      private void setName(JComponent jc, String name) {
            jc.setName(name);
      }

      private static void setDATAComponents() {
            String[] listT = new String[5];
            Font f = new Font("Dialog", Font.PLAIN, 24);
            for (int a = 0; a < 10; a++) {
                  DATA.lbs[a] = new JLabel("LB_" + (a + 1));
                  DATA.lbs[a].setName("LB_" + (a + 1));
                  DATA.lbs[a].setForeground(Color.WHITE);
                  DATA.lbs[a].setFont(f);

                  DATA.tfs[a] = new JTextField("TF_" + (a + 1));
                  DATA.tfs[a].setName("TF_" + (a + 1));
                  DATA.tfs[a].setBackground(Color.DARK_GRAY);
                  //DATA.tfs[a].setSize(, c1i);

                  for (int b = 0; b < 5; b++) {
                        listT[b] = "Element " + (b + 1);
                  }
                  DATA.lsts[a] = new JList(listT);
                  DATA.lsts[a].setName("LIST_" + (a + 1));
                  DATA.lsts[a].setBackground(Color.DARK_GRAY);
                  DATA.lsts[a].setForeground(Color.WHITE);

                  DATA.cbs[a] = new JComboBox();
                  DATA.cbs[a].setName("CB_" + (a + 1));

                  DATA.btns[a] = new JButton("BTN_" + (a + 1));
                  DATA.btns[a].setName("BTN_" + (a + 1));
            }
            setComponentsToString();
      }

      private void setComponentsToString() {
            ArrayList<String> list = new ArrayList<String>();
            for (int a = 0; a < 10; a++) {
                  list.add(DATA.lbs[a].getName());
                  list.add(DATA.tfs[a].getName());
                  list.add(DATA.lsts[a].getName());
                  list.add(DATA.btns[a].getName());
            }
            comps = list.toArray(new String[list.size()]);
            //String[] fff = (String[]) list.toArray();
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
            //VT_GLConfig();
            //+++++++++++++++++++++++
            JF.setVisible(true);
      }

      public static void main(String[] args) {
            new MainLayouts();
            //new Second();
      }
}

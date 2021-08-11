package swing.layouts;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.OverlayLayout;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;


/**
 *
 * @author C0FII
 */
class MainLayouts {

      private DATA data = DATA.getInstance();

      JFrame jf = new JFrame();
      JPanel jp = new JPanel();
      JScrollPane sc = new JScrollPane(jp);

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

      JPanel[] jps = new JPanel[txs.length];

      //+++++++++++++++++++++++++++++++++++
      private void cardLayoutConfig(JComponent jps) {
            //FOR LATER
      }

      private void groupLayoutMain(JComponent jps) {
            GroupLayout groupl = new GroupLayout(jps);
            jps.setLayout(groupl);

            //groupLayoutFirstEX(groupl);
            groupLayoutEXH2(groupl, 3);
      }

      private void groupLayoutFirstEX(GroupLayout layout) {
            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);
            layout.setHonorsVisibility(true);
            //++++++++++++++++++++++++++++++++++
            int gw = data.lbs[0].getPreferredSize().width;

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
                  ph1.addComponent(data.lbs[a]);
                  ph1.addGap(gw);
            }
            sh.addGroup(ph2);
            for (int a = 0; a < limit; a++) {
                  ph2.addComponent(data.tfs[a], 20, 90, 220);
                  ph2.addComponent(data.lsts[a], 60, 150, 300);
            }
            sh.addGroup(ph3);
            for (int a = 0; a < limit; a++) {
                  ph3.addComponent(data.cbs[a], 40, 40, 40);
                  ph3.addGap(gw);
            }

            sh.addGroup(ph4);
            for (int a = 0; a < limit; a++) {
                  ph4.addComponent(data.btns[a]);
                  ph4.addGap(gw);
            }

            for (int a = 0; a < limit; a++) {
                  ParallelGroup pv1 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
                  sv.addGroup(pv1);

                  pv1.addComponent(data.lbs[a]);
                  pv1.addComponent(data.tfs[a]);
                  pv1.addComponent(data.cbs[a]);
                  pv1.addComponent(data.btns[a]);

                  ParallelGroup pv2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
                  sv.addGroup(pv2);

                  pv2.addGap(0);
                  pv2.addComponent(data.lsts[a]);
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
                                                    .addComponent(data.lbs[0])
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(data.tfs[0], GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(data.cbs[0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(data.lsts[0])))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(data.lbs[0])
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(data.tfs[1])
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(data.cbs[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(data.btns[0])
                                            .addComponent(data.btns[1]))
                                    .addContainerGap(106, Short.MAX_VALUE))
            );
      }

      private void groupLayoutEX_H(GroupLayout layout) {
            //VERTICAL GROUP (Parallel LEADING)

            int lstPref = 200;
            int tfPref = 150;
            int cbPref = 50;
            layout.setAutoCreateGaps(true);

            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                                            .addComponent(data.lbs[0])
                                            .addGap(0)
                                            .addComponent(data.lbs[1]))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(data.tfs[0], tfPref, tfPref, Short.MAX_VALUE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(data.cbs[0], cbPref, cbPref, cbPref))
                                            .addComponent(data.lsts[0], lstPref, lstPref, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(data.tfs[1], tfPref, tfPref, Short.MAX_VALUE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(data.cbs[1], cbPref, cbPref, cbPref)))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                                            .addComponent(data.btns[0])
                                            .addGap(0)
                                            .addComponent(data.btns[1]))));

            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(data.lbs[0])
                                            .addComponent(data.tfs[0])
                                            .addComponent(data.cbs[0])
                                            .addComponent(data.btns[0]))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(data.lsts[0])
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(data.lbs[1])
                                            .addComponent(data.tfs[1])
                                            .addComponent(data.cbs[1])
                                            .addComponent(data.btns[1]))));
      }

      private void groupLayoutEXH2(GroupLayout gl, int limit) {
            gl.setAutoCreateGaps(true);
            gl.setAutoCreateContainerGaps(true);

            ParallelGroup pgh1 = gl.createParallelGroup(GroupLayout.Alignment.LEADING, true);
            ParallelGroup pgh2 = gl.createParallelGroup(GroupLayout.Alignment.LEADING, true);
            ParallelGroup pgh3 = gl.createParallelGroup(GroupLayout.Alignment.LEADING, true);

            SequentialGroup sgv1 = gl.createSequentialGroup();
            int lstPref = 200;
            int tfPref = 150;
            int conPref = 50;

            for (int a = 0; a < limit; a++) {
                  pgh1.addComponent(data.lbs[a]);
                  pgh1.addGap(0);
                  //++++++++++++++++++++++++++
                  pgh2.addGroup(gl.createSequentialGroup()
                          .addComponent(data.tfs[a], tfPref, tfPref, Short.MAX_VALUE)
                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(data.cbs[a], conPref, conPref, conPref));
                  pgh2.addComponent(data.lsts[a], lstPref, lstPref, Short.MAX_VALUE);
                  //++++++++++++++++++++++++++
                  pgh3.addComponent(data.btns[a]);
                  pgh3.addGap(0);
                  //=========================================
                  sgv1.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                          .addComponent(data.lbs[a])
                          .addComponent(data.tfs[a])
                          .addComponent(data.cbs[a])
                          .addComponent(data.btns[a]));
                  sgv1.addComponent(data.lsts[a]);
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

      private void gridBagLayout(JComponent jps) {
            GridBagLayout gbl = new GridBagLayout();
            jps.setLayout(gbl);
            GridBagConstraints c = new GridBagConstraints();

            for (int a = 0; a < 2; a++) {
                  c.fill = GridBagConstraints.HORIZONTAL;
                  c.weightx = 1;
                  c.weighty = 1;
                  c.gridx = a;
                  c.gridy = 0;
                  c.anchor = GridBagConstraints.FIRST_LINE_START;

                  jps.add(new JButton("Button " + (a + 1)), c);
            }
            c.fill = GridBagConstraints.HORIZONTAL;
            c.ipady = 40;      //make this component tall
            c.weightx = 0.0;
            c.gridwidth = 3;
            c.gridx = 0;
            c.gridy = 1;
            jps.add(new JButton("Button 4"), c);
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
                              for (int a = 0; a < jps.length; a++) {
                                    if (e.getComponent() == jps[a]) {
                                          //System.out.println("\t" + txs[a]);
                                          System.out.println("\t" + jps[a].getMousePosition());
                                          JButton btn = new JButton("M");
                                          //btn.setBounds(0, 0, 60, 30);
                                          btn.setLocation(jps[a].getMousePosition());
                                          btn.setSize(60, 30);
                                          jps[a].add(btn);
                                          jps[a].repaint();
                                    }
                              }
                        }
                  }

                  @Override
                  public void mouseReleased(MouseEvent e) {
                        throw new UnsupportedOperationException();
                  }

                  @Override
                  public void mouseEntered(MouseEvent e) {
                        throw new UnsupportedOperationException();
                  }

                  @Override
                  public void mouseExited(MouseEvent e) {
                        throw new UnsupportedOperationException();
                  }

            };
            for (int a = 0; a < jps.length; a++) {
                  jps[a] = new JPanel();
                  jps[a].setBackground(Color.BLACK);
                  jps[a].setToolTipText(txs[a]);
                  jps[a].addMouseListener(ml);
            }

            jps[0].setLayout(null);
            jps[1].setLayout(new BorderLayout(2, 2));
            jps[2].setLayout(new BoxLayout(jps[2], BoxLayout.Y_AXIS));
            jps[3].setLayout(new CardLayout(2, 2));
            jps[4].setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
            gridBagLayout(jps[5]);
            jps[6].setLayout(new GridLayout(2, 2));
            groupLayoutMain(jps[7]);
            //JPS[8].setLayout(new MigLayout());
            jps[9].setLayout(new OverlayLayout(jps[9]));
            jps[10].setLayout(new SpringLayout());
      }

      //+++++++++++++++++++++++++++++++++++

      private void setName(JComponent jc, String name) {
            jc.setName(name);
      }

      private void setDATAComponents() {
            String[] listT = new String[5];
            Font f = new Font("Dialog", Font.PLAIN, 24);
            for (int a = 0; a < 10; a++) {
                  data.lbs[a] = new JLabel("LB_" + (a + 1));
                  data.lbs[a].setName("LB_" + (a + 1));
                  data.lbs[a].setForeground(Color.WHITE);
                  data.lbs[a].setFont(f);

                  data.tfs[a] = new JTextField("TF_" + (a + 1));
                  data.tfs[a].setName("TF_" + (a + 1));
                  data.tfs[a].setBackground(Color.DARK_GRAY);

                  for (int b = 0; b < 5; b++) {
                        listT[b] = "Element " + (b + 1);
                  }
                  data.lsts[a] = new JList<>(listT);
                  data.lsts[a].setName("LIST_" + (a + 1));
                  data.lsts[a].setBackground(Color.DARK_GRAY);
                  data.lsts[a].setForeground(Color.WHITE);

                  data.cbs[a] = new JComboBox<>();
                  data.cbs[a].setName("CB_" + (a + 1));

                  data.btns[a] = new JButton("BTN_" + (a + 1));
                  data.btns[a].setName("BTN_" + (a + 1));
            }
            setComponentsToString();
      }

      private void setComponentsToString() {
            ArrayList<String> list = new ArrayList<>();
            for (int a = 0; a < 10; a++) {
                  list.add(data.lbs[a].getName());
                  list.add(data.tfs[a].getName());
                  list.add(data.lsts[a].getName());
                  list.add(data.btns[a].getName());
            }
            comps = list.toArray(new String[list.size()]);
            //String[] fff = (String[]) list.toArray();
      }

      MainLayouts() {
            jf.setTitle("Layout Test");
            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jf.setAlwaysOnTop(true);
            //JF.setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.X_AXIS));
            jf.setLocationRelativeTo(null);
            jf.setLayout(new GridLayout(1, 1, 2, 2));
            jf.setSize(1200, 600);
            setDATAComponents();
            //JF.add(SC);
            //JP.setLayout(new GridLayout(2, 5, 2, 2));
            jf.add(sc);
            jp.setLayout(new CardLayout(2, 2));
            //MM.setComponentFitOnJFrame(sc, jf);
            jp.setSize(sc.getSize());

            setPanelsLayouts();
            for (int a = 0; a < jps.length; a++) {
                  setName(jps[a], ("JP_" + (a + 1)));
                  jp.add(jps[a], txs[a]);
            }
            //+++++++++++++++++++++++
            jf.setVisible(true);
      }

      public static void main(String[] args) {
            new MainLayouts();
      }
}

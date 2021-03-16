/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import com.cofii2.components.swing.ComboBoxCustom;
import com.cofii2.components.swing.TextAreaCustom;
import com.cofii2.components.swing.TextFieldCustom;
import com.cofii2.methods.MComp;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author C0FII
 */
public class MultiplePanels {

      private static final int max = 6;

      private final JFrame JF = new JFrame();
      private final JPanel[] panels = new JPanel[max];
      private final CardLayout[] cls = new CardLayout[max];

      private final JTextField[] tfs = new JTextField[max];
      private final JComboBox[] cbs = new JComboBox[max];
      private final JTextArea[] tas = new JTextArea[max];

      private JPanel panelC = new JPanel();
      private JComboBox cbN = new ComboBoxCustom();
      private static final String[] types = {"JTextField", "JComboBox", "JTextArea"};
      private JComboBox cbType = new ComboBoxCustom(types);
      private JButton btn_change = new JButton("Change Size");

      private static final Dimension panelsDimension = new Dimension(Short.MAX_VALUE, 80);

      private MultiplePanels() {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.getContentPane().setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.Y_AXIS));
            //+++++++++++++++++++++++++++++++++++++++++++++++
            for (int a = 0; a < max; a++) {
                  panels[a] = new JPanel();

                  JF.getContentPane().add(panels[a], a);
                  panels[a].setMaximumSize(panelsDimension);
                  if (a % 2 == 0) {
                        panels[a].setBackground(Color.BLACK);
                  } else {
                        panels[a].setBackground(Color.GRAY);
                  }

                  cls[a] = new CardLayout();
                  panels[a].setLayout(cls[a]);

                  tfs[a] = new TextFieldCustom();
                  panels[a].add(tfs[a], "JTextField");
                  tfs[a].setMaximumSize(new Dimension(Short.MAX_VALUE, 30));

                  cbs[a] = new ComboBoxCustom(
                          new String[]{"element 1", "element 2", "element 3", "element 4", "element 5", "element 6"});
                  panels[a].add(cbs[a], "JComboBox");
                  cbs[a].setMaximumSize(new Dimension(Short.MAX_VALUE, 30));

                  tas[a] = new TextAreaCustom();
                  panels[a].add(tas[a], "JTextArea");
                  tas[a].setMaximumSize(new Dimension(Short.MAX_VALUE, 80));

                  cls[a].show(panels[a], "JTextField");
                  //++++++++++++++++++++++++++++++++++++
                  cbN.addItem((a + 1));
            }
            
           

            JF.getContentPane().add(Box.createVerticalGlue(), -1);
            JF.getContentPane().add(panelC, -1);
            panelC.setBackground(Color.BLUE);

            panelC.setLayout(new BoxLayout(panelC, BoxLayout.X_AXIS));
            panelC.add(cbN, 0);
            cbN.setMaximumSize(new Dimension(40, 30));
            panelC.add(cbType, 1);
            cbType.setMaximumSize(new Dimension(200, 30));
            panelC.add(btn_change, 2);
            btn_change.setMaximumSize(new Dimension(180, 28));
            btn_change.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        int index = cbN.getSelectedIndex();
                        String type = cbType.getSelectedItem().toString();

                        for (int a = 0; a < types.length; a++) {
                              if (type.equals(types[a])) {

                                    cls[index].show(panels[index], types[a]);
                                    if (a == types.length - 1) {
                                          panels[index].setPreferredSize(new Dimension(Short.MAX_VALUE, 80));
                                    }
                              }
                        }

                  }

            });

      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        MultiplePanels tt = new MultiplePanels();
                        tt.JF.setSize(new Dimension(300, 200));
                        MComp.setFrameToCenterOfScreen(tt.JF);
                        tt.JF.setVisible(true);
                  }

            });
      }
}

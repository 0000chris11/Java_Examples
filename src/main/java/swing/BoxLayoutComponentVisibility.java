/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import com.cofii2.components.swing.TextFieldCustom;
import com.cofii2.methods.MComp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author C0FII
 */
public class BoxLayoutComponentVisibility {

      private static final int max = 6;

      private final JFrame JF = new JFrame();
      private final JPanel[] panels = new JPanel[max];

      private final JTextField[] tfs = new JTextField[max];
      private final JButton[] btns = new JButton[max];
      ;
      private JButton btn_change = new JButton("HIDE / UNHIDE");

      private BoxLayoutComponentVisibility() {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.getContentPane().setBackground(Color.BLACK);
            JF.getContentPane().setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.Y_AXIS));
            //+++++++++++++++++++++++++++++++++++++++++++++++
            for (int a = 0; a < max - 1; a++) {
                  panels[a] = new JPanel();
                  JF.getContentPane().add(panels[a]);
                  panels[a].setBackground(Color.GRAY.darker());
                  panels[a].setMinimumSize(new Dimension(260, 27));
                  panels[a].setPreferredSize(new Dimension(260, 27));
                  panels[a].setMaximumSize(new Dimension(260, 27));
                  panels[a].setLayout(new BoxLayout(panels[a], BoxLayout.X_AXIS));

                  tfs[a] = new TextFieldCustom();
                  btns[a] = new JButton("+X+");

                  panels[a].add(tfs[a]);
                  panels[a].add(btns[a]);

                  tfs[a].setMinimumSize(new Dimension(200, 27));
                  tfs[a].setPreferredSize(new Dimension(200, 27));
                  tfs[a].setMaximumSize(new Dimension(200, 27));
                  btns[a].setMinimumSize(new Dimension(60, 27));
                  btns[a].setPreferredSize(new Dimension(60, 27));
                  btns[a].setMaximumSize(new Dimension(60, 27));

            }
            panels[max - 1] = new JPanel();
            JF.getContentPane().add(panels[max - 1]);
            panels[max - 1].setBackground(Color.BLACK);
            panels[max - 1].setLayout(new BoxLayout(panels[max - 1], BoxLayout.X_AXIS));
            panels[max - 1].add(btn_change);
            //++++++++++++++++++++++++++++++++++++++++++++++
            btn_change.setMaximumSize(new Dimension(180, 28));
            btn_change.addPropertyChangeListener("selection", new PropertyChangeListener(){
                  @Override
                  public void propertyChange(PropertyChangeEvent evt) {
                        System.out.println("!!!!!!!!!!!!! TEST !!!!!!!!!!!!");
                  }
                  
            });
            btn_change.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        if (btns[1].isVisible()) {
                              btns[1].setVisible(false);
                        }else{
                              btns[1].setVisible(true);
                        }
                  }

            });

      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        BoxLayoutComponentVisibility tt = new BoxLayoutComponentVisibility();
                        tt.JF.setSize(new Dimension(300, 200));
                        MComp.setFrameToCenterOfScreen(tt.JF);
                        tt.JF.setVisible(true);
                  }

            });
      }
}

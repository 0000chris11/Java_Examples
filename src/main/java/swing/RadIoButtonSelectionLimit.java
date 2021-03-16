/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import com.cofii2.methods.MComp;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author C0FII
 */
public class RadIoButtonSelectionLimit {

      private static final int MAX = 6;

      private JFrame JF = new JFrame();
      private JRadioButton[] rbs = new JRadioButton[MAX];

      private JButton btn_change = new JButton("Change");

      private RadIoButtonSelectionLimit() {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.getContentPane().setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.Y_AXIS));

            for (int a = 0; a < MAX; a++) {
                  rbs[a] = new JRadioButton("Num " + (a + 1));
                  JF.getContentPane().add(rbs[a], a);
            }

            btn_change.setMaximumSize(new Dimension(180, 28));
            btn_change.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {

                  }

            });

      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        RadIoButtonSelectionLimit tt = new RadIoButtonSelectionLimit();
                        tt.JF.setSize(new Dimension(300, 200));
                        MComp.setFrameToCenterOfScreen(tt.JF);
                        tt.JF.setVisible(true);
                  }

            });
      }
}

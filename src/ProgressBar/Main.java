package ProgressBar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 *
 * @author C0FII
 */
public class Main {
      
      JFrame JF = new JFrame();
      
      JButton btn = new JButton("ACTION");
      JProgressBar JPB = new JProgressBar(0, 30);
      
      public Main() {
            JF.setDefaultCloseOperation(3);
            JF.setAlwaysOnTop(true);
            JF.setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.Y_AXIS));
            
            JF.add(JPB);
            JF.add(btn);
            btn.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        new Thread() {
                              public void run() {
                                    for (int a = 1; a < JPB.getMaximum() + 1; a++) {
                                          try {
                                                Thread.sleep(1000);
                                          } catch (InterruptedException ex) {
                                                ex.printStackTrace();
                                          }
                                          
                                          JPB.setValue(a);
                                    }
                                    if (JPB.getValue() == JPB.getMaximum()) {
                                          JPB.setForeground(Color.GREEN);
                                    }
                              }
                        }.start();
                  }
                  
            });
            JF.pack();
      }
      
      public static void main(String[] args) {
            new Main().JF.setVisible(true);
      }
}

package swing.progressbar;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 *
 * @author C0FII
 */
class Main {
      
      JFrame jf = new JFrame();
      
      JButton btn = new JButton("ACTION");
      JProgressBar jpb = new JProgressBar(0, 30);
      
      Main() {
            jf.setDefaultCloseOperation(3);
            jf.setAlwaysOnTop(true);
            jf.setLayout(new BoxLayout(jf.getContentPane(), BoxLayout.Y_AXIS));
            
            jf.add(jpb);
            jf.add(btn);

            btn.addActionListener(e -> {
                  new Thread() {
                        @Override
                        public void run() {
                              for (int a = 1; a < jpb.getMaximum() + 1; a++) {
                                    try {
                                          Thread.sleep(1000);
                                    } catch (InterruptedException ex) {
                                          ex.printStackTrace();
                                          Thread.currentThread().interrupt();
                                    }
                                    
                                    jpb.setValue(a);
                              }
                              if (jpb.getValue() == jpb.getMaximum()) {
                                    jpb.setForeground(Color.GREEN);
                              }
                        }
                  }.start();

            });
            jf.pack();
      }
      
      public static void main(String[] args) {
            new Main().jf.setVisible(true);
      }
}

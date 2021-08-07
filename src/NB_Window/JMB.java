
package NB_Window;

import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.WindowConstants;

/**
 *
 * @author C0FII
 */
public class JMB implements forWindow{

      @Override
      public void frameConfig() {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setBounds(0, 0, 1000, 500);
            JF.setLayout(null);
            JF.setVisible(true);
            
            JF.add(JP);
            JP.setLayout(null);
            JP.setBackground(Color.BLACK);
            JP.setBounds(2, 42, 996, 456);
            
            JF.add(JB);
            JB.setBounds(0, 0, 1000, 42);
            JB.add(new JMenu("First"));
            JB.add(new JMenu("Second"));
            
      }
      
      public JMB(){
            frameConfig();
      }
      
      public static void main(String[] args){
            new JMB();
      }
      
}

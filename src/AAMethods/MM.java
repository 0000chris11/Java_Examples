/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAMethods;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Christopher
 */
public class MM {
      public static void setComponentToCenterJFrame(JComponent JC, JFrame JF){
            JC.setBounds(2, 2, 
                    JF.getWidth() - 21, 
                    JF.getHeight() - 44);
            //System.out.println("JP Bounds: " + jc.getBounds());
      }
}

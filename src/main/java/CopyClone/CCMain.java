/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CopyClone;

import javax.swing.JLabel;
import org.apache.commons.lang3.SerializationUtils;
/**
 *
 * @author C0FII
 */
public class CCMain {
      
      JLabel label = new JLabel("LABEL");
      Object object = "Object";
      String string = "String";
      int n = 1;
      
      public CCMain(){
            JLabel newLabel = SerializationUtils.clone(label);
            System.out.println(label.getClass());
            System.out.println(newLabel.getClass());
      }
      
      public static void main(String[] args){
            new CCMain();
      }
}

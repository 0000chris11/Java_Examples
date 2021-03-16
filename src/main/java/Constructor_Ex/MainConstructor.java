/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructor_Ex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

/**
 *
 * @author C0FII
 */
public class MainConstructor {

      public static void main(String[] args) {
            //String text = ((smallBTN_C) jc).getText();
            OtherConstructor oc = new OtherConstructor("AVA");
            try {
                  Constructor c = oc.getClass().getConstructor(String.class);
                  Parameter[] p = c.getParameters();
                  System.out.println("Parameter 0: " + p[0].toString());
            } catch (NoSuchMethodException | SecurityException ex) {
                  ex.printStackTrace();
            }
      }
}

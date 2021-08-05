/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

import basic_reusable_classes.OneAttributeWC;

/**
 *
 * @author C0FII
 */
public class AccesParameters {

      public static void main(String[] args) {
            //String text = ((smallBTN_C) jc).getText();
            OneAttributeWC oc = new OneAttributeWC("AVA");
            try {
                  Constructor<?> constructor = oc.getClass().getConstructor(String.class);
                  Parameter[] parameters = constructor.getParameters();
                  System.out.println("Parameter 0: " + parameters[0].toString());
            } catch (NoSuchMethodException | SecurityException ex) {
                  ex.printStackTrace();
            }
      }
}

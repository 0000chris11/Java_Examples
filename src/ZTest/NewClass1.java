/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZTest;

import ZTest.NewClass1.TextInput;

/**
 *
 * @author Christopher
 */
public class NewClass1 {

      public static class TextInput {

            static String Value = "";

            public void add(char c) {
                  Value += c;
            }

            public String getValue() {
                  return Value;
            }
      }

      public static class NumericInput extends TextInput {

            public void add(char c) {
                  System.out.println("ADD");
                  Object cc = (Object) c;
                  try {
                        int ddd = Integer.parseInt(Character.toString(c));
                        Value += ddd;
                  }catch(NumberFormatException ex){
                        
                  }
                  System.out.println("\t Integer");

            }
      }

      public static void main(String[] args) {
            TextInput input = new NumericInput();
            input.add('1');
            input.add('a');
            input.add('0');
            System.out.println(input.getValue());
      }
}

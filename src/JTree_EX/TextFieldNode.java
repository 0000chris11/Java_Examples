/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTree_EX;

/**
 *
 * @author Christopher
 */
public class TextFieldNode {
      
      String text; 
      
      public TextFieldNode(String tx){
            text = tx;
      }
      //++++++++++++++++++++++++++++
      public String getText() {
            return text;
      }

      public void setText(String newValue) {
            text = newValue;
      }
}

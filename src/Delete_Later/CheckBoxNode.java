/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delete_Later;

public class CheckBoxNode {
      
      String text;
      boolean selected;

      public CheckBoxNode(String text, boolean selected) {
            this.text = text;
            this.selected = selected;
      }
      //+++++++++++++++++++++++++++++++++
      public boolean isSelected() {
            return selected;
      }

      public void setSelected(boolean newValue) {
            selected = newValue;
      }

      public String getText() {
            return text;
      }

      public void setText(String newValue) {
            text = newValue;
      }
      //+++++++++++++++++++++++++++++++++++++++
      @Override
      public String toString() {
            System.out.println("calling toString()");
            return getClass().getName() + "[" + text + "/" + selected + "]";
      }
}

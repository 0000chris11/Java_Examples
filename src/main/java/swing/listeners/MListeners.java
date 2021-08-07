/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.listeners;

import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public class MListeners {
      
      private ArrayList<LTextChange> listTC = new ArrayList<>();
      private ArrayList<String> listTX = new ArrayList<>();
      
      public void addTextChangeListener(String text, LTextChange ml){
            listTC.add(ml);
            listTX.add(text);
            //FOR EACH TIME THE SAME INSTANCE ADD A LISTENER; IT CALLS EACH INDIVIDUAL ELEMENT
            for(LTextChange x : listTC){
                  x.textHasChanged();
            }
      }
}

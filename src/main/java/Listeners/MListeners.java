/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public class MListeners {
      
      private ArrayList<LTextChange> listTC = new ArrayList<LTextChange>();
      private ArrayList<String> listTX = new ArrayList<String>();
      
      public void addTextChangeListener(String text, LTextChange ml){
            listTC.add(ml);
            listTX.add(text);
            //FOR EACH TIME THE SAME INSTANCE ADD A LISTENER; IT CALLS EACH INDIVIDUAL ELEMENT
            for(LTextChange x : listTC){
                  x.textHasChanged();
            }
      }
}

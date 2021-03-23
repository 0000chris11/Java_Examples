/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author COFII
 */
public class CompareStrings {

      public static void main(String[] args) {
            
            List<String> list = new ArrayList<>();
            list.add("Pie");
            list.add("Twilight");
            list.add("Inaho");
            list.add("MOM");
            list.add("Sora");
            
          
            Collections.sort(list, new Comparator<String>(){
                  @Override
                  public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                  }
                  
            });
            
            for(String x : list){
                  System.out.println(x);
            }
      }
}

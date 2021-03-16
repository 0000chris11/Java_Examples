/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author C0FII
 */
public class ListCompare {

      public ListCompare() {
            //LINKEDLIST TO REMOVE - FASTER THAN ARRAYLIST
            //ARRAYLIST TO ADD AND GET - FASTER THAR LINKEDLIST
            
            LinkedList llist = new LinkedList();
            ArrayList list = new ArrayList();
            //+++++++++++++++++++++++++++++++++++++++++++++
            HashMap map = new HashMap();
            map.put("Song", "Tancevak");
            map.put("Artist", "IDR");
            map.put("Album", "IDR again");
            
            System.out.println("does this map contains this key: " + map.containsKey("Artist"));
            System.out.println("does this map contains this value: " + map.containsValue("NOPE"));
            System.out.println("Song's Value: " + map.get("Song").toString());
            //+++++++++++++++++++++++++++++++++++++++++++++
            //1. IGNORE REPEATED VALUES
            //2. DOES NOT GUARANTEE CORRECT ORDER
            HashSet<String> set = new HashSet<String>();
            set.add("A");
            set.add("B");
            set.add("C");
            set.add("D");
            set.add("E");
            set.add("A");
            set.add("B");
            System.out.println("\n HASHSET");
            for(String x : set){
                  System.out.println("\t" + set);
            }
      }
      
      public static void main(String[] args){
            
      }
}

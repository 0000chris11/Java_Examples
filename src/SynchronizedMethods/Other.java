/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SynchronizedMethods;

/**
 *
 * @author Christopher
 */
public class Other extends Main_Sync{
      
      public Other(){
            this.decrementSlowly();
      }
      public static void main(String[] args){
            System.out.println("Other Thread Star");
            new Other();
            new Main_Sync();
      }
}

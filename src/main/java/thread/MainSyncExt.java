/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author C0FII
 */
public class MainSyncExt extends MainSync{
      
      public MainSyncExt(){
            this.decrementSlowly();
      }
      public static void main(String[] args){
            System.out.println("Other Thread Star");
            new MainSyncExt();
            new MainSync();
      }
}

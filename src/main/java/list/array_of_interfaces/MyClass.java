/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list.array_of_interfaces;

/**
 *
 * @author C0FII
 */
public class MyClass{

      static ArrayMethods AM = new ArrayMethods();
      
      public void selectString() {
            System.out.println("\tThis is a String");
      }

      public void selectInt() {
            System.out.println("\tThis is a int");
      }
      
      public MyClass(){
            //System.out.println("First Index");
            //AM.getSelect()[0].hold();
            //AM.getSelect()[1].hold();
      }
      
      public static void main(String[] args) {
            System.out.println("First Index");
            AM.getSelect()[0].hold();
            AM.getSelect()[1].hold();
            //Array_Methods.choose(0);
            //new MyClass().;
      }
      
}

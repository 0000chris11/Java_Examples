package SynchronizedMethods;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christopher
 */
public class Main_Sync {

      private int c = 0;

      //++++++++++++++++++++++++++++++++++
      public synchronized void increment() {
            c++;
      }

      public synchronized void decrement() {
            c--;
      }

      //+++++++++++++++++++++++++++++++++++
      public synchronized void incrementSlowly() {
            new Thread() {
                  public void run() {
                        try {
                              Thread.sleep(10000);
                              c++;
                        } catch (InterruptedException ex) {
                              ex.printStackTrace();
                        }
                  }
            }.start();
      }

      public synchronized void decrementSlowly() {
            new Thread() {
                  public void run() {
                        try {
                              Thread.sleep(10000);
                              c--;
                        } catch (InterruptedException ex) {
                              ex.printStackTrace();
                        }
                  }
            }.start();
      }

      //+++++++++++++++++++++++++++++++++++
      public synchronized int getValue() {
            return c;
      }

      public Main_Sync(){
            incrementSlowly();
            new Thread() {
                  public void run() {
                        incrementSlowly();
                        System.out.println("Value: " + getValue());
                  }
            }.start();
      }
      //+++++++++++++++++++++++++++++++++++
      public static void main(String[] args) {
            System.out.println("Main_Sync Thread Star");
            
            
      }
      //++++++++++++++++++++++++++++++++++
}

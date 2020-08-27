package Wait;

import java.util.logging.Level;
import java.util.logging.Logger;

public class wait_Notify {

      public static void waiting() {
            System.out.println(" Number 1");

            try {
                  //System.out.println(" Number 1");

                  Thread.sleep(2000);

                  //System.out.println(" Number 2");
            } catch (InterruptedException ex) {
                  Logger.getLogger(wait_Notify.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(" Number 2");
      }

      public static void main(String[] args) {

            waiting();

      }

}



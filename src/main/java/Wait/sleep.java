
package Wait;

import java.util.concurrent.TimeUnit;

public class sleep {
      public static void main(String[] args) throws InterruptedException{
            
            System.out.println("FIRST");
            
            waitt();
            
            System.out.println("SECOND");
      }
      
      private static void waitt() throws InterruptedException{
            
            TimeUnit.SECONDS.sleep(2);
            
      }
}

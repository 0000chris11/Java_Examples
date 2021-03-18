package Wait;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class thirdTest {

      public static void main(String[] args) {
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

            executorService.schedule(mm("aaa"), 10, TimeUnit.SECONDS);
            executorService.sc
            
      }
      
      public static String mm(String text){
            
            String nt = text.toUpperCase();
            
            return nt;
      }
}
